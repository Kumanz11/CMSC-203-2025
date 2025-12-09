package assignment6;
import java.util.InputMismatchException;
/**
 * Custom exception to wrap input mismatch situations.
 */
public class CustomInputMismatchException extends InputMismatchException {
    public CustomInputMismatchException(String message) {
        super(message);
    }
}
