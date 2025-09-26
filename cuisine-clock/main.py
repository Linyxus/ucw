import re
import sys
import os
from datetime import datetime
from typing import Dict, List, Optional

from textual.app import App, ComposeResult
from textual.widgets import Static, Input, Label, Digits
from textual.containers import Container, Horizontal, Vertical, Grid
from textual.binding import Binding


class KitchenTimer:
    def __init__(self, name: str, duration_seconds: int):
        self.name = name
        self.duration_seconds = duration_seconds
        self.start_time = datetime.now()
        self.paused = False
        self.paused_duration = 0
        self.completed = False

    @property
    def remaining_seconds(self) -> int:
        if self.completed:
            return 0

        if self.paused:
            elapsed = self.paused_duration
        else:
            elapsed = (datetime.now() - self.start_time).total_seconds() - self.paused_duration

        remaining = self.duration_seconds - elapsed
        return max(0, int(remaining))

    @property
    def is_finished(self) -> bool:
        return self.remaining_seconds <= 0 and not self.completed

    def mark_completed(self):
        self.completed = True

    def pause(self):
        if not self.paused:
            self.paused = True
            self.pause_start = datetime.now()

    def resume(self):
        if self.paused:
            self.paused_duration += (datetime.now() - self.pause_start).total_seconds()
            self.paused = False

    def format_time(self) -> str:
        seconds = self.remaining_seconds
        if seconds == 0:
            return "DONE!"

        hours = seconds // 3600
        minutes = (seconds % 3600) // 60
        secs = seconds % 60

        if hours > 0:
            return f"{hours:02d}:{minutes:02d}:{secs:02d}"
        else:
            return f"{minutes:02d}:{secs:02d}"

    def get_digits_time(self) -> str:
        """Get time in format suitable for Digits widget (always numeric)"""
        seconds = self.remaining_seconds

        hours = seconds // 3600
        minutes = (seconds % 3600) // 60
        secs = seconds % 60

        if hours > 0:
            return f"{hours:02d}:{minutes:02d}:{secs:02d}"
        else:
            return f"{minutes:02d}:{secs:02d}"


    def get_status_icon(self) -> str:
        if self.completed:
            return "✅"
        elif self.is_finished:
            return "🔔"
        elif self.paused:
            return "⏸️"
        else:
            return "⏱️"

    def get_color_class(self) -> str:
        if self.completed or self.remaining_seconds == 0:
            return "timer-done"
        elif self.remaining_seconds < 60:
            return "timer-urgent"
        elif self.remaining_seconds < 300:  # 5 minutes
            return "timer-warning"
        else:
            return "timer-normal"


class DurationParser:
    @staticmethod
    def parse(duration_str: str) -> int:
        duration_str = duration_str.lower().strip()

        # Handle colon format (mm:ss or hh:mm:ss)
        if ':' in duration_str:
            parts = duration_str.split(':')
            if len(parts) == 2:  # mm:ss
                return int(parts[0]) * 60 + int(parts[1])
            elif len(parts) == 3:  # hh:mm:ss
                return int(parts[0]) * 3600 + int(parts[1]) * 60 + int(parts[2])

        # Handle text formats
        total_seconds = 0

        # Hours
        hours_match = re.search(r'(\d+)\s*h(?:ours?)?', duration_str)
        if hours_match:
            total_seconds += int(hours_match.group(1)) * 3600

        # Minutes
        mins_match = re.search(r'(\d+)\s*m(?:ins?|inutes?)?', duration_str)
        if mins_match:
            total_seconds += int(mins_match.group(1)) * 60

        # Seconds
        secs_match = re.search(r'(\d+)\s*s(?:ecs?|econds?)?', duration_str)
        if secs_match:
            total_seconds += int(secs_match.group(1))

        # If no units found, treat as minutes
        if total_seconds == 0:
            number_match = re.search(r'(\d+)', duration_str)
            if number_match:
                total_seconds = int(number_match.group(1)) * 60

        return total_seconds


class TimerManager:
    def __init__(self):
        self.timers: Dict[str, KitchenTimer] = {}

    def add_timer(self, name: str, duration_str: str) -> bool:
        try:
            duration_seconds = DurationParser.parse(duration_str)
            if duration_seconds <= 0:
                return False
            self.timers[name] = KitchenTimer(name, duration_seconds)
            return True
        except (ValueError, AttributeError):
            return False

    def remove_timer(self, name: str) -> bool:
        if name in self.timers:
            del self.timers[name]
            return True
        return False

    def get_finished_timers(self) -> List[KitchenTimer]:
        return [timer for timer in self.timers.values() if timer.is_finished]

    def mark_timers_completed(self, timers: List[KitchenTimer]):
        for timer in timers:
            timer.mark_completed()

    def clear_completed(self):
        self.timers = {name: timer for name, timer in self.timers.items()
                      if not timer.completed}

    def pause_timer(self, name: str) -> bool:
        if name in self.timers:
            self.timers[name].pause()
            return True
        return False

    def resume_timer(self, name: str) -> bool:
        if name in self.timers:
            self.timers[name].resume()
            return True
        return False

    def list_timers(self) -> List[KitchenTimer]:
        return list(self.timers.values())





def beep():
    """Make a system beep sound"""
    try:
        if sys.platform == "darwin":  # macOS
            os.system("afplay /System/Library/Sounds/Glass.aiff")
        elif sys.platform.startswith("linux"):
            os.system("pactl play-sample bell-terminal")
        else:  # Windows and fallback
            print("\a", end="", flush=True)
    except:
        print("\a", end="", flush=True)


class TimerCard(Container):
    """A beautiful card widget to display a single timer"""

    def __init__(self, timer: KitchenTimer, **kwargs):
        super().__init__(**kwargs)
        self.timer = timer

    def compose(self) -> ComposeResult:
        yield Label(self.timer.name, classes="timer-name")
        yield Digits(self.timer.get_digits_time(), classes="timer-time", id=f"timer-digits-{self.timer.name}")
        yield Label(self.timer.get_status_icon(), classes="timer-icon")

    def get_state_class(self) -> str:
        """Get CSS class based on timer state"""
        if self.timer.is_finished and not self.timer.completed:
            return "timer-finished"
        elif self.timer.remaining_seconds < 60:
            return "timer-urgent"
        elif self.timer.remaining_seconds < 300:  # 5 minutes
            return "timer-warning"
        elif self.timer.paused:
            return "timer-paused"
        else:
            return "timer-normal"

    def on_mount(self) -> None:
        """Apply state-based CSS class when mounted"""
        self.add_class(self.get_state_class())

    def update_timer(self) -> None:
        """Update the timer display"""
        # Remove old state classes
        for cls in ["timer-finished", "timer-urgent", "timer-warning", "timer-paused", "timer-normal"]:
            self.remove_class(cls)
        # Add current state class
        self.add_class(self.get_state_class())

        # Update labels and digits
        name_label = self.query_one(".timer-name", Label)
        time_digits = self.query_one(".timer-time", Digits)
        icon_label = self.query_one(".timer-icon", Label)

        name_label.update(self.timer.name)
        time_digits.update(self.timer.get_digits_time())
        icon_label.update(self.timer.get_status_icon())


class TimerGrid(Container):
    """Container to display timer cards in a 3-column grid"""

    def __init__(self, timer_manager: TimerManager, **kwargs):
        super().__init__(**kwargs)
        self.timer_manager = timer_manager
        self.timer_cards = {}  # Dictionary to track existing timer cards by timer name

    def compose(self) -> ComposeResult:
        # This will be dynamically populated
        return []

    def update_timers(self) -> None:
        """Update the grid with current timers"""
        timers = self.timer_manager.list_timers()

        if not timers:
            # Clear everything if no timers
            self.remove_children()
            self.timer_cards.clear()
            self.mount(Static("No active timers. Try: a pasta 10m", classes="no-timers"))
            return

        # Get current timer names
        current_timer_names = {timer.name for timer in timers}
        existing_timer_names = set(self.timer_cards.keys())

        # Remove cards for timers that no longer exist
        for timer_name in existing_timer_names - current_timer_names:
            if timer_name in self.timer_cards:
                self.timer_cards[timer_name].remove()
                del self.timer_cards[timer_name]

        # Update existing cards and create new ones
        for timer in timers:
            if timer.name in self.timer_cards:
                # Update existing card
                self.timer_cards[timer.name].update_timer()
            else:
                # Create new card
                if not self.timer_cards:  # First timer, remove "no timers" message
                    self.remove_children()

                card = TimerCard(timer, classes="timer-card")
                self.mount(card)
                self.timer_cards[timer.name] = card




class CuisineClockApp(App):
    """Main Textual app for Cuisine Clock - Starting Simple"""

    CSS = """
    Screen {
        layout: vertical;
    }

    #main_area {
        height: 1fr;
        margin: 1;
        padding: 1;
    }

    #status_bar {
        height: 1;
        margin: 0 1;
        padding: 0 1;
        background: $panel;
        color: $text;
        text-align: center;
    }

    #command_input {
        height: 3;
        margin: 0 1 1 1;
        border: solid blue;
        background: $surface;
    }

    /* Timer Grid Styling */
    .timer-grid {
        layout: vertical;
        align: center top;
    }

    .timer-row {
        layout: horizontal;
        height: auto;
        margin: 1 0;
        align: center top;
    }

    /* Timer Card Base Styling */
    .timer-card {
        width: 30;
        height: 12;
        margin: 0 1;
        padding: 1;
        border: round;
        layout: vertical;
        align: center middle;
    }

    .timer-card .timer-name {
        text-align: center;
        width: 100%;
        height: 1;
        margin: 0;
        padding: 0;
    }


    .timer-card .timer-time {
        text-align: center;
        width: 100%;
        height: 6;
        margin: 1 0;
        padding: 0;
    }

    .timer-card .timer-icon {
        text-align: center;
        width: 100%;
        height: 1;
        margin: 0;
        padding: 0;
    }

    /* Timer State Colors */
    .timer-card.timer-normal {
        border: solid green;
        background: $surface;
    }

    .timer-card.timer-normal .timer-name {
        color: green;
    }

    .timer-card.timer-normal .timer-time {
        color: ansi_bright_green;
    }


    .timer-card.timer-warning {
        border: solid yellow;
        background: $surface;
    }

    .timer-card.timer-warning .timer-name {
        color: yellow;
    }

    .timer-card.timer-warning .timer-time {
        color: ansi_bright_yellow;
    }


    .timer-card.timer-urgent {
        border: solid red;
        background: $surface;
    }

    .timer-card.timer-urgent .timer-name {
        color: red;
    }

    .timer-card.timer-urgent .timer-time {
        color: ansi_bright_red;
    }


    .timer-card.timer-finished {
        border: solid red;
        background: $error 20%;
    }

    .timer-card.timer-finished .timer-name {
        color: ansi_bright_red;
    }

    .timer-card.timer-finished .timer-time {
        color: ansi_bright_red;
        text-style: bold;
    }


    .timer-card.timer-paused {
        border: solid blue;
        background: $surface;
    }

    .timer-card.timer-paused .timer-name {
        color: blue;
    }

    .timer-card.timer-paused .timer-time {
        color: ansi_bright_blue;
    }


    .empty-slot {
        width: 30;
        height: 12;
        margin: 0 1;
    }

    .no-timers {
        text-align: center;
        margin: 2;
        padding: 2;
        color: $text-muted;
    }

    .app-title {
        text-align: center;
        margin: 1 0;
        padding: 1;
        text-style: bold;
        color: $accent;
    }
    """

    BINDINGS = [
        ("ctrl+c", "quit", "Quit"),
        ("q", "quit", "Quit"),
    ]

    def __init__(self) -> None:
        super().__init__()
        self.timer_manager = TimerManager()

    def compose(self) -> ComposeResult:
        yield Vertical(
            Static("🍳 Cuisine Clock - Kitchen Timer", classes="app-title"),
            TimerGrid(self.timer_manager, classes="timer-grid", id="timer_grid"),
            id="main_area"
        )
        yield Static("Ready", id="status_bar")
        yield Input(placeholder="Commands: a pasta 10m | rem pasta | p pasta | res pasta | q (abbreviations work!)", id="command_input")

    def on_mount(self) -> None:
        self.title = "Cuisine Clock"
        # Focus the command input immediately
        command_input = self.query_one("#command_input")
        command_input.focus()
        # Start the timer update loop with faster refresh for smoother operation
        self.set_interval(0.1, self.update_display)

    def on_input_submitted(self, message: Input.Submitted) -> None:
        """Handle command submission"""
        command = message.value.strip()

        # Clear the input
        message.input.clear()

        # Process the command (even if empty to show error)
        result = self.process_command(command)

        # Update the main area with the result and refresh display
        if result == "quit":
            self.exit()
        else:
            self.update_display()
            # Show the command result in the status bar
            status_bar = self.query_one("#status_bar")
            status_bar.update(result)
            # Clear status bar after 3 seconds
            self.set_timer(3.0, lambda: status_bar.update("Ready"))

    def match_command(self, cmd_input):
        """Match command abbreviation to full command. Returns (matched_command, error_message)"""
        commands = ["add", "remove", "pause", "resume", "quit", "exit"]
        cmd_input = cmd_input.lower()

        # Special case for 'q' -> 'quit'
        if cmd_input == "q":
            return "quit", ""

        # Exact match first
        if cmd_input in commands:
            return cmd_input, ""

        # Find commands that start with the input
        matches = [cmd for cmd in commands if cmd.startswith(cmd_input)]

        if len(matches) == 0:
            return "", f"❌ Unknown command: {cmd_input}. Commands: add, remove, pause, resume, quit"
        elif len(matches) == 1:
            return matches[0], ""
        else:
            return "", f"❌ Ambiguous command: {cmd_input}. Could be: {', '.join(matches)}"

    def process_command(self, command: str) -> str:
        """Process commands"""
        parts = command.split()
        if not parts:
            return "❌ Empty command. Try: a pasta 10m"

        cmd_input = parts[0]
        cmd, error = self.match_command(cmd_input)
        if error:
            return error

        if cmd == "add":
            if len(parts) < 3:
                return "❌ Usage: add <name> <duration> (e.g., a pasta 10m)"
            name = parts[1]
            duration = " ".join(parts[2:])
            if self.timer_manager.add_timer(name, duration):
                return f"✅ Added timer '{name}' for {duration}"
            else:
                return f"❌ Invalid duration: {duration}"

        elif cmd == "remove":
            if len(parts) != 2:
                return "❌ Usage: remove <name> (e.g., rem pasta)"
            name = parts[1]
            if self.timer_manager.remove_timer(name):
                return f"✅ Removed timer '{name}'"
            else:
                return f"❌ Timer '{name}' not found"

        elif cmd == "pause":
            if len(parts) != 2:
                return "❌ Usage: pause <name> (e.g., p pasta)"
            name = parts[1]
            if self.timer_manager.pause_timer(name):
                return f"⏸️ Paused timer '{name}'"
            else:
                return f"❌ Timer '{name}' not found"

        elif cmd == "resume":
            if len(parts) != 2:
                return "❌ Usage: resume <name> (e.g., res pasta)"
            name = parts[1]
            if self.timer_manager.resume_timer(name):
                return f"▶️ Resumed timer '{name}'"
            else:
                return f"❌ Timer '{name}' not found"

        elif cmd in ["quit", "exit"]:
            return "quit"

        else:
            return f"❌ Unknown command: {cmd}. Commands: add, remove, pause, resume, quit"

    def update_display(self) -> None:
        """Update the main display with current timer status"""
        # Check for finished timers first
        finished_timers = self.timer_manager.get_finished_timers()
        if finished_timers:
            self.timer_manager.mark_timers_completed(finished_timers)
            for timer in finished_timers:
                beep()
                self.title = f"🔔 Timer '{timer.name}' finished!"
                self.set_timer(3.0, lambda: setattr(self, 'title', 'Cuisine Clock'))

        # Update the timer grid
        timer_grid = self.query_one("#timer_grid", TimerGrid)
        timer_grid.update_timers()

    def action_quit(self) -> None:
        """Quit the application"""
        self.exit()


def main():
    app = CuisineClockApp()
    app.run()


if __name__ == "__main__":
    main()
