package exceptions;

public class IdAlreadyExistsException extends Exceptions {
  private static final String ID_ALREADY_EXISTS = "%s already exists!";

    public IdAlreadyExistsException(String id) {
        super(String.format(ID_ALREADY_EXISTS, id));
    }
}
