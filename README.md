# Notes App — Java File I/O

[![Java](https://img.shields.io/badge/Java-File%20I%2FO-orange?logo=openjdk)](https://www.java.com/) [![Repository](https://img.shields.io/badge/GitHub-Source-181717?logo=github)](https://github.com/kandisaikishore/NotesApp) [![Last Commit](https://img.shields.io/github/last-commit/kandisaikishore/NotesApp)](https://github.com/kandisaikishore/NotesApp/commits/main)

A small Java notes manager created to practise file handling, reading and writing text, and building a menu-driven console application.

## Highlights

- Create and save notes
- Read notes stored locally
- Practise Java file input/output and exception handling
- Learn how a console application can work with local text files

The exact editing, deletion, and file format behaviour depends on the current implementation.

## Tech stack

- Java / JDK
- Java file I/O (for example, readers and writers)

## Prerequisites

Install a JDK and confirm `java` and `javac` are available.

## Run locally

```bash
git clone https://github.com/kandisaikishore/NotesApp.git
cd NotesApp
javac NotesApp.java
java NotesApp
```

If your local source has additional classes or a different entry point, compile the required files and run the class containing `main`.

## Data and privacy

Notes are kept in local files if file persistence is enabled by the implementation. Back up files you need to keep. This educational app should not be treated as encrypted storage for confidential information.

## Possible next steps

- Add edit, delete, search, and categories
- Include timestamps for created and updated notes
- Improve file error handling and input validation
- Add tests for reading, writing, and missing-file scenarios

## Contributing

Submit focused changes with clear reproduction steps and verification details.

## License

No license file is currently declared. Add a `LICENSE` file to define reuse terms.
