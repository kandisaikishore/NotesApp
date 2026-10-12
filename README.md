# Notes App — Java File I/O

A text-based notes manager built to practise Java file handling and basic menu-driven application design.

## Features

- Add and save notes
- Read previously saved notes
- Append new notes rather than replacing existing content (as implemented)
- Store notes in a text file such as `notes.txt`

## Technology

- Java
- File I/O with `FileWriter`, `FileReader`, and `BufferedReader`
- Any Java IDE or terminal

## Run locally

Install a JDK and clone the repository:

```bash
git clone https://github.com/saikishore2410/NotesApp.git
cd NotesApp
```

Compile the Java files and run the class containing `main`. For example, if the entry point is `Main` and files are in the default package:

```bash
javac *.java
java Main
```

Use the actual entry-point class name if it differs.

## Data and limitations

Notes are stored in a local file. Back up that file if its contents matter, and do not treat this simple project as encrypted or multi-user storage.

## Ideas to extend

- Edit and delete notes
- Add timestamps, categories, and search
- Validate input and handle I/O errors clearly
- Add automated tests

## Contributions

Small, well-scoped fixes and improvements are welcome.

## License

No license is specified. Add a `LICENSE` file before granting reuse rights.