import java.time.LocalDate;

public interface LiteratureNote extends Note{

    void setId(String id);

    void setContent(String content);

    void setDate(String date);

    String getTitle();

    String getAuthor();

    LocalDate getDocumentDate();

    String getLink();

    String getQuote();

    @Override
    String toString();
}
