package util;

public class wrongDataException extends Exception{
    public wrongDataException() {
        super();
    }

    public wrongDataException(String message) {
        super(message);
    }

    public wrongDataException(String message, Throwable cause) {
        super(message, cause);
    }
}
