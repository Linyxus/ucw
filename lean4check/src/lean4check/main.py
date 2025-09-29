"""
lean4check MCP Server - A Lean 4 build wrapper MCP server
"""

import argparse
import subprocess
from dataclasses import dataclass
from pathlib import Path
from mcp.server.fastmcp import FastMCP

# Global variable to store the Lean 4 project root
LEAN4_ROOT: Path | None = None


@dataclass
class CLIResult:
    """Result of executing a CLI command."""
    stdout: str = ""
    stderr: str = ""
    returncode: int | None = None
    timed_out: bool = False
    error: str | None = None


def execute_command(
    args: list[str],
    cwd: Path | None = None,
    timeout: int = 300
) -> CLIResult:
    """
    Execute a CLI command and capture its output.

    Args:
        args: Command and arguments as a list
        cwd: Working directory for the command
        timeout: Timeout in seconds

    Returns:
        CLIResult containing the command output and status
    """
    try:
        result = subprocess.run(
            args,
            cwd=cwd,
            capture_output=True,
            text=True,
            timeout=timeout
        )

        return CLIResult(
            stdout=result.stdout,
            stderr=result.stderr,
            returncode=result.returncode
        )

    except subprocess.TimeoutExpired:
        return CLIResult(timed_out=True)
    except FileNotFoundError:
        return CLIResult(error=f"Command not found: {args[0]}")
    except Exception as e:
        return CLIResult(error=f"Error running command: {e}")


def build_module(module: str) -> CLIResult:
    """
    Build a Lean 4 module using lake.

    Args:
        module: The module name to build

    Returns:
        CLIResult containing the build output and status
    """
    if LEAN4_ROOT is None:
        return CLIResult(error="No Lean 4 project root specified. Use --root argument.")

    if not LEAN4_ROOT.exists():
        return CLIResult(error=f"Project root {LEAN4_ROOT} does not exist.")

    if not (LEAN4_ROOT / "lakefile.lean").exists() and not (LEAN4_ROOT / "lakefile.toml").exists():
        return CLIResult(error=f"No lakefile found in {LEAN4_ROOT}. Not a valid Lean 4 project.")

    return execute_command(
        ["lake", "build", module],
        cwd=LEAN4_ROOT,
        timeout=300
    )


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
    result = build_module(module)

    if result.error:
        return f"Error: {result.error}"

    if result.timed_out:
        return f"Error: lake build {module} timed out after 300 seconds."

    output = []
    if result.stdout:
        output.append(f"STDOUT:\n{result.stdout}")
    if result.stderr:
        output.append(f"STDERR:\n{result.stderr}")

    output.append(f"Exit code: {result.returncode}")

    return "\n\n".join(output) if output else "No output from lake build."


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


# if __name__ == "__main__":
#     main()
