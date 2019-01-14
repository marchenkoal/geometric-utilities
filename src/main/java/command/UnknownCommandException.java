package command;

public class UnknownCommandException extends Exception {
    UnknownCommandException(String message) {
        super(message);
    }
}
