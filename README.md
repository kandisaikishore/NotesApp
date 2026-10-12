# Notes App — Java File I/O

## Live Demo / Deployment URL

**Deployment URL:** Not verified yet. Add the confirmed public application URL here after checking the live service. This repository's GitHub URL is the source code, not a deployed application.


[![GitHub](https://img.shields.io/badge/GitHub-Repository-181717?logo=github)](https://github.com/saikishore2410/NotesApp) [![Issues](https://img.shields.io/github/issues/saikishore2410/NotesApp)](https://github.com/saikishore2410/NotesApp/issues) [![Last Commit](https://img.shields.io/github/last-commit/saikishore2410/NotesApp)](https://github.com/saikishore2410/NotesApp/commits/main)

> A text-based notes manager built to practise Java file handling and menu-driven application design.

## At a glance

- **Purpose:** Use the feature and scope sections below to understand the problem this project addresses.
- **Getting started:** Follow the repository-specific setup instructions and verify commands against the current source and package scripts.
- **Configuration:** Keep API keys, database credentials, tokens, and private user data out of commits; configure secrets locally.
- **Quality checks:** Run the available build, test, and lint commands before submitting changes.



A text-based notes manager built to practise Java file handling and menu-driven application design.

## Features

- Add and save notes
- Read previously saved notes
- Append new notes instead of replacing existing content, where implemented
- Store notes in a local text file such as `notes.txt`

## Technology

- Java
- File I/O with `FileWriter`, `FileReader`, and `BufferedReader`

## Run locally

Install a JDK and clone the repository:

```bash
git clone https://github.com/saikishore2410/NotesApp.git
cd NotesApp
javac *.java
```

Run the class containing `main` (for example, `java Main` if `Main` is the entry point). Use the actual class name if it differs.

## Data and limitations

Notes are stored in a local file. Back up the file if its contents matter; this simple application should not be treated as encrypted or multi-user storage.

## Ideas to extend

- Edit and delete notes
- Add timestamps, categories, and search
- Handle I/O errors and invalid input clearly
- Add automated tests

## Contributions

Small, well-scoped fixes with clear test steps are welcome.

## License

No license is specified. Add a `LICENSE` file before granting reuse rights.