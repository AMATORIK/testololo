package exceptions;

public class NoteDoesNotExistsException extends Exceptions {
    private static final String ID_DOES_NOT_EXISTS = "%s does not exist!";

    public NoteDoesNotExistsException(String id) {
        super(String.format(ID_DOES_NOT_EXISTS, id));
    }
}
