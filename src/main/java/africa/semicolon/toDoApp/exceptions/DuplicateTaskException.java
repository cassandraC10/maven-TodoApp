package africa.semicolon.toDoApp.exceptions;

public class DuplicateTaskException extends ApplicationException{

    public DuplicateTaskException(String message) {
        super(message);
    }
}
