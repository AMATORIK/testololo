import java.time.LocalDate;
import java.util.List;

public interface Note {
    String getId();
    LocalDate getDate();
    String getContent();
    List<Tag> getTags();
    List<String> getLinks();
    boolean addTag(Tag tag);
    boolean removeTag(Tag tag);
}
