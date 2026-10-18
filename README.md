# NotesApp — Java File-Based Notes Manager

[![Java](https://img.shields.io/badge/Java-CLI-orange?logo=openjdk)](https://www.java.com/) [![Repository](https://img.shields.io/badge/GitHub-Source-181717?logo=github)](https://github.com/kandisaikishore/NotesApp)

A lightweight, menu-driven Java application for creating and viewing personal notes from the terminal. Notes are appended to a local `notes.txt` file, so entries remain available between runs as long as the file is kept.

## Features

- Add a note through a console prompt
- View saved notes in the terminal
- Append notes to `notes.txt` without overwriting previous entries
- Handle a missing notes file with a user-facing message
- Practise Java file I/O, exception handling, loops, and console input

## Technology

- Java / JDK
- `Scanner` for console interaction
- `FileWriter` and `BufferedReader` for file-based storage

## Requirements

Install a JDK and confirm that `java` and `javac` are available from your terminal.

## Run locally

```bash
git clone https://github.com/kandisaikishore/NotesApp.git
cd NotesApp
javac NotesApp.java
java NotesApp
```

Choose **1** to add a note, **2** to view saved notes, or **3** to exit. The file `notes.txt` is read or created relative to the directory from which the program is launched.

## Project structure

```text
NotesApp/
├── NotesApp.java       # Console menu and file I/O
├── NotesAppTest.java   # Test source
├── notes.txt           # Local notes data (created as needed)
└── README.md
```

## Validation ideas

Check adding multiple notes, viewing an empty or populated file, restarting the application, and entering invalid menu input. The current menu parses the choice as an integer, so non-numeric input should be handled in a future improvement.

## Roadmap

- Validate menu input without terminating unexpectedly
- Add search and delete functionality
- Support note timestamps or categories
- Add automated tests with a standard Java test framework

## Contributing

Open an issue with reproduction steps or submit a focused pull request with the checks you ran.

## License

No license file is currently declared. Add a `LICENSE` file to define reuse and distribution terms.


## REST API and browser UI

The browser interface now calls a Java Spring Boot REST API. Install JDK 17+ and Maven, then start the API from the repository root:

```bash
cd api
mvn spring-boot:run
```

Open the UI at `http://localhost:8082/`. The API uses port 8082. API endpoints are under `/api`. Current API data is held in server memory and resets when the process restarts; configure a database before production use. The API module is separate from the original console/Swing classes, so it does not share their in-process state.
