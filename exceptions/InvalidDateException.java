package exceptions;

public class InvalidDateException extends Exceptions {
  private static final String INVALID_DATE = "Invalid date!";

    public InvalidDateException() {
        super(INVALID_DATE);
    }
}
