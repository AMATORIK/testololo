import exceptions.Exceptions;

import java.time.LocalDate;
import java.util.ArrayList;

public interface NotesApplication {
    void addLiteratureNote(String kind, LocalDate localDate1, String id, String content,
                           String title, String author, LocalDate localDate2, String link,
                           String quote) throws Exceptions;

    void addPermanentNote(String kind, LocalDate localDate, String id, String content) throws Exceptions;

    int getNumberOfNotes();

    void addTag(String noteId, String tagId) throws Exceptions;

    void removeTag(String noteId, String tagId) throws Exceptions;

}
