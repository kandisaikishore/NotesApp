import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.charset.MalformedInputException;
import java.nio.file.Path;
import java.util.List;

public class NotesAppTest {
    private static void check(boolean condition, String message) {
        if (!condition) throw new AssertionError(message);
    }

    public static void main(String[] args) throws Exception {
        Path directory = Files.createTempDirectory("notes-app-test-");
        Path file = directory.resolve("notes.txt");

        try {
            check(NotesApp.readNotes(file).isEmpty(), "a missing file should return an empty note list");

            Files.createFile(file);
            check(NotesApp.readNotes(file).isEmpty(), "an empty file should return an empty note list");

            check(NotesApp.writeNote(file, "first note"), "first note should be saved");
            check(NotesApp.writeNote(file, "తెలుగు మరియు 日本語"), "Unicode note should be saved");

            List<String> notes = NotesApp.readNotes(file);
            check(notes.size() == 2, "both notes should be preserved");
            check(notes.get(0).equals("first note"), "existing note should remain unchanged");
            check(notes.get(1).equals("తెలుగు మరియు 日本語"), "Unicode note should round-trip as UTF-8");

            Path directoryAsFile = directory.resolve("not-a-file");
            Files.createDirectory(directoryAsFile);
            check(!NotesApp.writeNote(directoryAsFile, "must fail"), "writing to a directory should fail safely");

            Files.write(file, new byte[] {(byte) 0xC3, (byte) 0x28});
            boolean malformedRejected = false;
            try {
                NotesApp.readNotes(file);
            } catch (MalformedInputException expected) {
                malformedRejected = true;
            }
            check(malformedRejected, "malformed UTF-8 should be reported instead of silently decoded");

            System.out.println("Notes tests passed");
        } finally {
            Files.deleteIfExists(file);
            Path directoryAsFile = directory.resolve("not-a-file");
            Files.deleteIfExists(directoryAsFile);
            Files.deleteIfExists(directory);
        }
    }
}
