import exceptions.*;

import java.time.LocalDate;
import java.util.ArrayList;

public class NotesApplicationClass implements NotesApplication {

    ArrayList<Note> notes = new ArrayList<>();
    ArrayList<Tag> tags = new ArrayList<>();
    private LocalDate lastDate;

    @Override
    public void addPermanentNote(String kind, LocalDate noteDate, String id, String content)
            throws Exceptions {
        addNote(kind, noteDate, id, content, null, null, null, null, null);
    }

    @Override
    public void addLiteratureNote(String kind, LocalDate noteDate, String id, String content,
                                  String title, String author, LocalDate documentDate, String link,
                                  String quote) throws Exceptions {
        addNote(kind, noteDate, id, content, title, author, documentDate, link, quote);
    }

    private void addNote(String kind, LocalDate noteDate, String id, String content,
                         String title, String author, LocalDate documentDate, String link,
                         String quote) throws Exceptions {
        NoteKind noteKind = NoteKind.fromString(kind);

        if (lastDate != null && noteDate.isBefore(lastDate)) {
            throw new NoTimeTravellingException();
        }
        lastDate = noteDate;

        for (Note note : notes) {
            if (note.getId().equals(id)) {
                throw new IdAlreadyExistsException(id);
            }
        }

        if (noteKind == NoteKind.LITERATURE) {
            if (documentDate.isAfter(lastDate))
                throw new NoTimeTravellingToFutureException();
            LiteratureNote literatureNote = new LiteratureNoteClass(noteDate.toString(), id,
                    content, title, author, documentDate, link, quote);
            notes.add(literatureNote);
        } else if (noteKind == NoteKind.PERMANENT) {
            PermanentNote permanentNote = new PermanentNoteClass(noteDate.toString(), id, content);
            notes.add(permanentNote);
        }
    }

    public void addTag(String noteId, String tagId) throws Exceptions {
        if(!doesNoteExists(noteId)) throw new NoteDoesNotExistsException(noteId);
        Tag tag;
        if(getTagById(tagId) != null) {
            tag = getTagById(tagId);
        } else {
            tag = new Tag(tagId);
            tags.add(tag);
        }
        if (getNoteById(noteId).doesTagMatched(tag)) throw new TagAlreadyMatchedException(noteId, tagId);
        getNoteById(noteId).matchTag(tag);
    }

    public void addTag1(String noteId, String tagId) throws Exceptions {
        Note note = getNoteById(noteId);
        if (note == null) throw new NoteDoesNotExistsException(noteId);
        Tag tag = getTagById(tagId);
        if (tag == null) {
            tag = new Tag(tagId);
            tags.add(tag);
        } else {
            if (note.doesTagMatched(tag)) throw new TagAlreadyMatchedException(noteId, tagId);
        }
        getNoteById(noteId).matchTag(tag);
    }

    public void removeTag(String noteId, String tagId) throws Exceptions {
        if(!doesNoteExists(noteId)) throw new NoteDoesNotExistsException(noteId);
        Tag tag = getTagById(tagId);
        if(tag == null | !getNoteById(noteId).doesTagMatched(tag)) throw new TagNotMatchedException(noteId, tagId);
        getNoteById(noteId).unmatchTag(tag);
    }

    private Note getNoteById(String id) {
        for (Note note : notes) {
            if (note.getId().equals(id)) {
                return note;
            }
        }
        return null;
    }

    private boolean doesNoteExists(String id) {
        for (Note note : notes) {
            if (note.getId().equals(id)) {
                return true;
            }
        }
        return false;
    }

    private Tag getTagById(String id) {
        for (Tag tag : tags) {
            if (tag.getTagId().equals(id)) {
                return tag;
            }
        }
        return null;
    }

    @Override
    public int getNumberOfNotes() {
        return 0;
    }
}
