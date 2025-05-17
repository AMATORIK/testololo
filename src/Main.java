import exceptions.*;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.Scanner;
/**
 * @author Taisiia Hlukha (67398) t.hlukha@campus.fct.unl.pt
 * @author Daniil Fylypenko (70187) d.fylypenko@campus.fct.unl.pt
 */
public class Main {
    /**
     * Feedbacks in our program
     */
    private static final String NOTE_CREATED = "Note %s created successfully " +
            "with links to %d tagNotes.%n";
    private static final String UNKNOWN_COMMAND = "Unknown command. " +
            "Type help to see available commands.";
    private static final String LOCAL_DATE = "yyyy MM dd";
    private static final String END_PROGRAM = "Bye!";

    private static final String INVALID_DATE = "Invalid date!";
    private static final String INVALID_DOCUMENT_DATE = "Invalid document date!";
    private static final String TAGGED = "%s tagged with %s.%n";
    private static final String UNTAGGED = "Note %s no longer tagged with %s.%n";

    /**
     * Main method, that execute command interpreter
     *
     * @param args this args was not used in this program
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        NotesApplication notes = new NotesApplicationClass();
        Command command;
        do {
            String input = in.next().toLowerCase();
            command = Command.fromString(input);

            if (command == null) {
                System.out.println(UNKNOWN_COMMAND);
                continue;
            }

            switch (command) {
                case CREATE -> createCommand(in, notes);
                case READ -> readCommand(in, notes);
                case UPDATE -> updateCommand(in, notes);
                case LINKS -> linksCommand(in, notes);
                case TAG -> tagCommand(in, notes);
                case UNTAG -> untagCommand(in, notes);
                case TAGS -> tagsCommand(in, notes);
                case TAGGED -> taggedCommand(in, notes);
                case TRENDING -> trendingCommand(in, notes);
                case NOTES -> notesCommand(in, notes);
                case DELETE -> deleteCommand(in, notes);
                case HELP -> System.out.println(Command.getAllCommandsDescription());
                case EXIT -> System.out.println(END_PROGRAM);
            }
        } while (command != Command.EXIT);
    }

    /**
     * This method is used to create a command
     *
     * @param in   Scanner object
     * @param notes NotesApplication object
     */
    private static void createCommand(Scanner in, NotesApplication notes) {
        String kind = in.next();
        String date = in.nextLine().trim();
        String id = in.nextLine().trim();
        String content = in.nextLine().trim();
        NoteKind noteKind = null;
        LocalDate noteDate = null;
        try {
            noteDate = safeParseDate(date, noteKind);
        } catch (DateTimeException e) {
            System.out.println(INVALID_DATE);
            return;
        }
        noteKind = NoteKind.fromString(kind);
        try {
            if (noteKind == NoteKind.LITERATURE) {
                String title = in.nextLine().trim();
                String author = in.nextLine().trim();
                String publicationDate = in.nextLine();
                String link = in.nextLine().trim();
                String quote = in.nextLine().trim();
                LocalDate documentDate = null;
                try {
                    documentDate = safeParseDate(publicationDate, noteKind);
                } catch (DateTimeException e) {
                    System.out.println(INVALID_DOCUMENT_DATE);
                    return;
                }
                notes.addLiteratureNote(kind, noteDate, id, content, title, author, documentDate,
                        link, quote);
            }
            else {
                notes.addPermanentNote(kind, noteDate, id, content);
            }
            System.out.printf(NOTE_CREATED, id, notes.getNumberOfNotes());
        }
        catch (Exceptions e) {
            System.out.println(e.getMessage());
        }
    }

    private static LocalDate safeParseDate(String input, NoteKind kind) throws DateTimeException {
        String[] parts = input.trim().split("\\s+");
        if (parts.length != 3) {
            if (kind == NoteKind.LITERATURE)
                throw new DateTimeException(INVALID_DOCUMENT_DATE);
            else
                throw new DateTimeException(INVALID_DATE);
        }

        int year = Integer.parseInt(parts[0]);
        int month = Integer.parseInt(parts[1]);
        int day = Integer.parseInt(parts[2]);

        // Попытка создать дату — если дата невалидна (например, 30 февраля), будет выброшено исключение
        LocalDate parsedDate = LocalDate.of(year, month, day);

        // Дополнительная проверка не требуется, потому что LocalDate.of уже строгий
        return parsedDate;
    }

    private static void readCommand(Scanner in, NotesApplication notes) {
    }

    private static void updateCommand(Scanner in, NotesApplication notes) {
    }

    private static void linksCommand(Scanner in, NotesApplication notes) {
    }

    private static void tagCommand(Scanner in, NotesApplication notes) {
        String noteId = in.nextLine().trim();
        String tagId = in.nextLine().trim();
        try {
            notes.addTag(noteId, tagId);
            System.out.printf(TAGGED, noteId, tagId);
        } catch (Exceptions e) {
            System.out.println(e.getMessage());
        }
    }

    private static void untagCommand(Scanner in, NotesApplication notes) {
        String noteId = in.nextLine().trim();
        String tagId = in.nextLine().trim();
        try {
            notes.removeTag(noteId, tagId);
            System.out.printf(UNTAGGED, noteId, tagId);
        } catch (Exceptions e) {
            System.out.println(e.getMessage());
        }
    }

    private static void tagsCommand(Scanner in, NotesApplication notes) {
    }

    private static void taggedCommand(Scanner in, NotesApplication notes) {
    }

    private static void trendingCommand(Scanner in, NotesApplication notes) {
    }

    private static void notesCommand(Scanner in, NotesApplication notes) {
    }

    private static void deleteCommand(Scanner in, NotesApplication notes) {
    }

}