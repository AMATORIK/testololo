import java.time.LocalDate;

public class LiteratureNoteClass extends NoteClass implements LiteratureNote {
    private String title;
    private String author;
    private LocalDate documentDate;
    private String link;
    private String quote;

    public LiteratureNoteClass(String noteDate, String id, String content, String title,
                               String author, LocalDate documentDate, String link, String quote) {
        super(noteDate, id, content);
        this.title = title;
        this.author = author;
        this.documentDate = documentDate;
        this.link = link;
        this.quote = quote;
    }
    @Override
    public String getTitle() {
        return title;
    }
    @Override
    public String getAuthor() {
        return author;
    }
    @Override
    public LocalDate getDocumentDate() {
        return documentDate;
    }
    @Override
    public String getLink() {
        return link;
    }
    @Override
    public String getQuote() {
        return quote;
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
    @Override
    public String toString() {
        return "LiteratureNote{" +
                "date='" + date + '\'' +
                ", id='" + id + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
