import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;
import java.util.Scanner;

public class NotesApp {
    private static final String FILE_NAME = "notes.txt";

    static boolean writeNote(Path file, String note) {
        try {
            Files.writeString(
                file,
                note + System.lineSeparator(),
                StandardCharsets.UTF_8,
                StandardOpenOption.CREATE,
                StandardOpenOption.WRITE,
                StandardOpenOption.APPEND
            );
            return true;
        } catch (IOException | SecurityException e) {
            return false;
        }
    }

    public static void writeNote(String note) {
        if (writeNote(Paths.get(FILE_NAME), note)) {
            System.out.println("Note saved successfully!");
        } else {
            System.out.println("Error saving note. Check file access and try again.");
        }
    }

    static List<String> readNotes(Path file) throws IOException {
        try {
            return Files.readAllLines(file, StandardCharsets.UTF_8);
        } catch (NoSuchFileException e) {
            return List.of();
        }
    }

    public static void readNotes() {
        try {
            List<String> notes = readNotes(Paths.get(FILE_NAME));
            if (notes.isEmpty()) {
                System.out.println("No notes found yet. Please add a note first.");
                return;
            }

            System.out.println("\nYour Notes:");
            for (String note : notes) {
                System.out.println("- " + note);
            }
        } catch (IOException | SecurityException e) {
            System.out.println("Error reading notes. The file may be unreadable or contain invalid UTF-8.");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n==== Notes App ====");
            System.out.println("1. Add Note");
            System.out.println("2. View Notes");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");

            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter your note: ");
                    String note = scanner.nextLine();
                    writeNote(note);
                    break;
                case 2:
                    readNotes();
                    break;
                case 3:
                    System.out.println("Exiting Notes App. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        } while (choice != 3);

        scanner.close();
    }
}
