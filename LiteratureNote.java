import java.time.LocalDate;

class LiteratureNote extends AbstractNote {
    private final String author;
    private final LocalDate publicationDate;
    private final String url;
    private final String quote;
    private final String title;

    public LiteratureNote(
            String id,
            LocalDate date,
            String title,
            String content,
            String author,
            LocalDate publicationDate,
            String url,
            String quote
    ) {
        super(id, date, content);
        this.author = author;
        this.title = title;
        this.publicationDate = publicationDate;
        this.url = url;
        this.quote = quote;
    }

    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public LocalDate getPublicationDate() { return publicationDate; }
    public String getUrl() { return url; }
    public String getQuote() { return quote; }
}
