# CLAUDE.md

This file provides guidance to Claude Code (claude.ai/code) when working with code in this repository.

## Project Overview

Cuisine Clock is a kitchen timer application built with Python and Textual TUI framework. It provides a terminal-based interface for managing multiple named cooking timers with features like pause/resume, visual notifications, and sound alerts.

## Commands

### Running the Application
```bash
uv run python main.py
```

### Dependencies Management
```bash
uv sync          # Install/sync dependencies
uv add <package> # Add new dependency
```

## Development Notes

- NEVER run `uv run python main.py` to test the application yourself, which will mess up the current Claude session. ALWAYS ask the user to test and let them get back to you.

