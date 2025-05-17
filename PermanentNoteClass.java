public class PermanentNoteClass extends NoteClass implements PermanentNote {
    public PermanentNoteClass(String date, String id, String content) {
        super(date, id, content);
    }
    @Override
    public String toString() {
        return String.format("%s %s %s", date, id, content);
    }
    @Override
    public void setId(String id) {
        this.id = id;
    }
    @Override
    public void setContent(String content) {
        this.content = content;
    }
    @Override
    public void setDate(String date) {
        this.date = date;
    }

}