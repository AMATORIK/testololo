package exceptions;

public class NoTimeTravellingException extends Exceptions {
   private static final String NO_TIME_TRAVELLING = "No time travelling!";

    public NoTimeTravellingException() {
        super(NO_TIME_TRAVELLING);
    }
}
