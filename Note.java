import java.util.ArrayList;

public interface Note {
    String getDate();

    String getId();

    String getContent();

    void matchTag(NotesApplication.Tag tag);

    void unmatchTag(NotesApplication.Tag tag);

    boolean doesTagMatched(NotesApplication.Tag tag);

}
