package exceptions;

public class InvalidDocumentDateException extends Exceptions {
  private static final String INVALID_DOCUMENT_DATE = "Invalid document date!";

    public InvalidDocumentDateException() {
        super(INVALID_DOCUMENT_DATE);
    }
}
