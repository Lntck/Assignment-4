package src;

/**
 * The SpeedOutOfBoundsException is thrown when an animal's speed exceeds the valid range.
 * It extends the Exception class and provides a custom error message.
 */
public final class SpeedOutOfBoundsException extends Exception {
    @Override
    public String getMessage() {
        return "The speed is out of bounds";
    }
}
