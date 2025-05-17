package exceptions;

public class NoTimeTravellingToFutureException extends Exceptions {
  private static final String NO_TIME_TRAVELLING_TO_FUTURE = "No time travelling to the future!";

  public NoTimeTravellingToFutureException() {
    super(NO_TIME_TRAVELLING_TO_FUTURE);
  }
}
