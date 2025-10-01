import argparse
import subprocess
import re
from pathlib import Path
from typing import List, Tuple, Dict
from dataclasses import dataclass


@dataclass
class FileChange:
    """Represents a changed file with its statistics."""
    path: str
    additions: int
    deletions: int
    annotated_content: str


def parse_arguments():
    """Parse command line arguments."""
    parser = argparse.ArgumentParser(
        description="Generate annotated diff summaries with conflict-style markers"
    )
    parser.add_argument(
        "-r", "--repo-path",
        required=True,
        help="Path to the git repository"
    )
    parser.add_argument(
        "-n", "--commits",
        type=int,
        required=True,
        help="Number of recent commits to analyze"
    )
    parser.add_argument(
        "-o", "--output",
        required=True,
        help="Output directory path"
    )
    return parser.parse_args()


def get_commit_range(repo_path: str, num_commits: int) -> Tuple[str, str]:
    """Get the oldest and newest commit in the range."""
    result = subprocess.run(
        ["git", "log", f"-{num_commits}", "--format=%H"],
        cwd=repo_path,
        capture_output=True,
        text=True,
        check=True
    )
    commits = result.stdout.strip().split('\n')
    if not commits or commits[0] == '':
        raise ValueError("No commits found in the specified range")

    newest_commit = commits[0]
    oldest_commit = commits[-1]
    return oldest_commit, newest_commit


def get_changed_files(repo_path: str, oldest_commit: str) -> List[str]:
    """Get list of all files changed since the oldest commit."""
    result = subprocess.run(
        ["git", "diff", "--name-only", f"{oldest_commit}^", "HEAD"],
        cwd=repo_path,
        capture_output=True,
        text=True,
        check=True
    )
    files = [f for f in result.stdout.strip().split('\n') if f]
    return files


def get_file_diff(repo_path: str, oldest_commit: str, file_path: str) -> str:
    """Get the unified diff for a specific file."""
    result = subprocess.run(
        ["git", "diff", f"{oldest_commit}^", "HEAD", "--", file_path],
        cwd=repo_path,
        capture_output=True,
        text=True,
        check=True
    )
    return result.stdout


def parse_and_annotate_diff(diff_content: str) -> Tuple[str, int, int]:
    """
    Parse unified diff and create annotated content with conflict-style markers.
    Returns: (annotated_content, additions, deletions)
    """
    lines = diff_content.split('\n')
    result = []
    additions = 0
    deletions = 0

    i = 0
    while i < len(lines):
        line = lines[i]

        # Skip diff header lines
        if line.startswith('diff --git') or line.startswith('index ') or \
           line.startswith('---') or line.startswith('+++'):
            i += 1
            continue

        # Skip hunk headers
        if line.startswith('@@'):
            i += 1
            continue

        # Handle changed lines
        if line.startswith('-'):
            # Collect all consecutive deletions
            deleted_lines = []
            while i < len(lines) and lines[i].startswith('-'):
                deleted_lines.append(lines[i][1:])  # Remove the '-' prefix
                deletions += 1
                i += 1

            # Check if there are corresponding additions
            added_lines = []
            while i < len(lines) and lines[i].startswith('+'):
                added_lines.append(lines[i][1:])  # Remove the '+' prefix
                additions += 1
                i += 1

            # Add conflict markers
            if deleted_lines and added_lines:
                result.append("<<<<<<< OLD")
                result.extend(deleted_lines)
                result.append("=======")
                result.extend(added_lines)
                result.append(">>>>>>> NEW")
            elif deleted_lines:
                result.append("<<<<<<< REMOVED")
                result.extend(deleted_lines)
                result.append(">>>>>>> REMOVED")
            elif added_lines:
                result.append("<<<<<<< ADDED")
                result.extend(added_lines)
                result.append(">>>>>>> ADDED")

        elif line.startswith('+'):
            # Pure addition (no preceding deletion)
            added_lines = []
            while i < len(lines) and lines[i].startswith('+'):
                added_lines.append(lines[i][1:])
                additions += 1
                i += 1

            result.append("<<<<<<< ADDED")
            result.extend(added_lines)
            result.append(">>>>>>> ADDED")

        elif line.startswith(' '):
            # Context line
            result.append(line[1:])  # Remove the ' ' prefix
            i += 1
        else:
            # Empty line or other
            if line:
                result.append(line)
            i += 1

    return '\n'.join(result), additions, deletions


def process_repository(repo_path: str, num_commits: int) -> List[FileChange]:
    """Process the repository and generate annotated changes for all files."""
    oldest_commit, newest_commit = get_commit_range(repo_path, num_commits)
    changed_files = get_changed_files(repo_path, oldest_commit)

    file_changes = []
    for file_path in changed_files:
        try:
            diff_content = get_file_diff(repo_path, oldest_commit, file_path)
            if not diff_content.strip():
                continue

            annotated_content, additions, deletions = parse_and_annotate_diff(diff_content)

            file_changes.append(FileChange(
                path=file_path,
                additions=additions,
                deletions=deletions,
                annotated_content=annotated_content
            ))
        except subprocess.CalledProcessError:
            # Skip files that can't be processed (binary files, etc.)
            continue

    return file_changes


def write_output(output_dir: str, file_changes: List[FileChange]):
    """Write annotated files and index to the output directory."""
    output_path = Path(output_dir)
    output_path.mkdir(parents=True, exist_ok=True)

    # Write each annotated file
    for change in file_changes:
        file_output_path = output_path / change.path
        file_output_path.parent.mkdir(parents=True, exist_ok=True)

        with open(file_output_path, 'w', encoding='utf-8') as f:
            f.write(change.annotated_content)

    # Generate index.md
    index_content = generate_index(file_changes)
    with open(output_path / 'index.md', 'w', encoding='utf-8') as f:
        f.write(index_content)


def generate_index(file_changes: List[FileChange]) -> str:
    """Generate the index.md content with change statistics."""
    lines = [
        "# Change Summary",
        "",
        "## Changed Files",
        "",
        "| File | Additions | Deletions | Total Changes |",
        "|------|-----------|-----------|---------------|"
    ]

    total_additions = 0
    total_deletions = 0

    for change in file_changes:
        total_changes = change.additions + change.deletions
        lines.append(
            f"| [{change.path}](./{change.path}) | "
            f"+{change.additions} | -{change.deletions} | {total_changes} |"
        )
        total_additions += change.additions
        total_deletions += change.deletions

    lines.extend([
        "",
        "## Summary",
        "",
        f"- **Total files changed:** {len(file_changes)}",
        f"- **Total additions:** +{total_additions}",
        f"- **Total deletions:** -{total_deletions}",
        f"- **Net change:** {total_additions - total_deletions} lines",
        ""
    ])

    return '\n'.join(lines)


def main():
    args = parse_arguments()

    print(f"Analyzing {args.commits} commits from {args.repo_path}...")

    try:
        file_changes = process_repository(args.repo_path, args.commits)

        print(f"Found {len(file_changes)} changed files")

        write_output(args.output, file_changes)

        print(f"Output written to {args.output}")
        print(f"View the summary at {args.output}/index.md")

    except subprocess.CalledProcessError as e:
        print(f"Error running git command: {e}")
        return 1
    except Exception as e:
        print(f"Error: {e}")
        return 1

    return 0


if __name__ == "__main__":
    exit(main())
