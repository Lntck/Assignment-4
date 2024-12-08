package src;

/**
 * Exception thrown when the amount of grass in the field is out of bounds.
 * This exception is triggered when an operation tries to set or manipulate the grass amount
 * that is outside the allowed range (minimum or maximum grass limits).
 */
public final class GrassOutOfBoundsException extends Exception {
    @Override
    public String getMessage() {
        return "The grass is out of bounds";
    }
}
