package exceptions;

public class TagAlreadyMatchedException extends Exceptions {
    private static final String TAG_MATCHED = "%s is already tagged with %s!";

    public TagAlreadyMatchedException(String noteId, String tagId) {
        super(String.format(TAG_MATCHED, noteId, tagId));
    }
}
