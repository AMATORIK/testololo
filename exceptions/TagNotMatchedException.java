package exceptions;

public class TagNotMatchedException extends Exceptions {
    private static final String TAG_NOT_MATCHED = "Note on %s is not tagged with %s!";

    public TagNotMatchedException(String noteId, String tagId) {
        super(String.format(TAG_NOT_MATCHED, noteId, tagId));
    }
}