"""
lean4check MCP Server - A Lean 4 build wrapper MCP server
"""

import argparse
import subprocess
from pathlib import Path
from mcp.server.fastmcp import FastMCP

# Global variable to store the Lean 4 project root
LEAN4_ROOT: Path | None = None

# Initialize the MCP server
mcp = FastMCP("lean4check")


@mcp.tool()
def check(module: str) -> str:
    """
    Check a Lean 4 module.

    Args:
        module: The module name to build (e.g., "Semantic.Fsub.Syntax")

    Returns:
        Results of checking the proofs.
    """
    if LEAN4_ROOT is None:
        return "Error: No Lean 4 project root specified. Use --root argument."

    if not LEAN4_ROOT.exists():
        return f"Error: Project root {LEAN4_ROOT} does not exist."

    if not (LEAN4_ROOT / "lakefile.lean").exists() and not (LEAN4_ROOT / "lakefile.toml").exists():
        return f"Error: No lakefile found in {LEAN4_ROOT}. Not a valid Lean 4 project."

    try:
        result = subprocess.run(
            ["lake", "build", module],
            cwd=LEAN4_ROOT,
            capture_output=True,
            text=True,
            timeout=60
        )

        output = []
        if result.stdout:
            output.append(f"STDOUT:\n{result.stdout}")
        if result.stderr:
            output.append(f"STDERR:\n{result.stderr}")

        output.append(f"Exit code: {result.returncode}")

        return "\n\n".join(output) if output else "No output from lake build."

    except subprocess.TimeoutExpired:
        return f"Error: lake build {module} timed out after 60 seconds."
    except FileNotFoundError:
        return "Error: 'lake' command not found. Please ensure Lean 4 is installed."
    except Exception as e:
        return f"Error running lake build: {e}"


def main():
    """Main entry point for the lean4check MCP server."""
    global LEAN4_ROOT

    parser = argparse.ArgumentParser(
        description="Lean 4 build wrapper MCP server"
    )
    parser.add_argument(
        "--root",
        type=Path,
        required=True,
        help="Root directory of the Lean 4 project"
    )

    args = parser.parse_args()
    LEAN4_ROOT = args.root.resolve()

    # Run the server with stdio transport
    mcp.run(transport='stdio')


if __name__ == "__main__":
    main()
