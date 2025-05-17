import java.util.ArrayList;

public abstract class NoteClass implements Note {
    public String date;
    public String id;
    public String content;
    ArrayList<NotesApplication.Tag> tags;

    public NoteClass(String date, String id, String content) {
        this.date = date;
        this.id = id;
        this.content = content;
        this.tags = new ArrayList<>();
    }

    public String getDate() {
        return date;
    }

    public String getId() {
        return id;
    }

    public void matchTag(NotesApplication.Tag tag) {
        tags.add(tag);
        tag.addNote(this);
    }

    public void unmatchTag(NotesApplication.Tag tag) {
        tags.remove(tag);
        tag.tagNotes.remove(this);
    }

    public String getContent() {
        return content;
    }

    public boolean doesTagMatched(NotesApplication.Tag tag) {
        for (NotesApplication.Tag t : tags) {
            if (t.getTagId().equals(tag.getTagId())) {
                return true;
            }
        }
        return false;
    }
}
