# Notes App — Java File I/O

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