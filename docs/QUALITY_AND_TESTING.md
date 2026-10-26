# Development and Testing Guide

NotesApp is a menu-driven Java notes manager that appends entries to a local `notes.txt` file. The file path is relative to the directory from which the program is launched.

## Prerequisites and run

Install a JDK, then run from the repository root:

```bash
javac NotesApp.java
java NotesApp
```

Use menu option 1 to add a note, 2 to view notes, and 3 to exit, as described in the README.

## File persistence behavior

- A successful add appends a note; it must not truncate existing notes.
- Viewing a missing file should show a clear message and should not crash.
- Use a consistent character encoding so Unicode notes can be saved and read reliably.
- If a read or write fails, report the problem clearly and preserve existing content.
- Explain that `notes.txt` is plain local text and is not encrypted or account-protected.

## Test matrix

Test adding one and multiple notes, empty/whitespace input, Unicode text, a missing file, an empty file, a file with multiple lines, and an unreadable or unwritable file where the environment permits. Verify that saved notes remain after restarting the program and that failed writes do not silently erase prior content.

If no test framework exists, record manual steps and observed output. Add automated tests in a separate focused change if the project structure supports them.

## Privacy and backup

Do not store passwords, access tokens, or other secrets in notes. Back up `notes.txt` before destructive experiments. Do not upload personal note content in bug reports.

## Pull-request checklist

- [ ] Run `javac NotesApp.java` and exercise the affected menu workflow.
- [ ] Add regression coverage for the reported behavior.
- [ ] Verify file errors do not cause data loss.
- [ ] Document the command run and its result.
