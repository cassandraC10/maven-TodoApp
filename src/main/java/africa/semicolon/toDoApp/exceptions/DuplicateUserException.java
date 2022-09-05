package africa.semicolon.toDoApp.exceptions;

public class DuplicateUserException extends ApplicationException {
    public DuplicateUserException(String message) {
        super(message);
    }

}
