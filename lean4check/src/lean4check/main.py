"""
lean4check MCP Server - A minimal example MCP server
"""

from mcp.server.fastmcp import FastMCP

# Initialize the MCP server
mcp = FastMCP("lean4check")


@mcp.tool()
def echo(message: str) -> str:
    """
    Echo tool that returns the input message.

    Args:
        message: The message to echo back

    Returns:
        The same message that was input
    """
    return f"Echo: {message}"


def main():
    """Main entry point for the lean4check MCP server."""
    # Run the server with stdio transport
    mcp.run(transport='stdio')


if __name__ == "__main__":
    main()
