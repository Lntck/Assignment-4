package src;

/**
 * The WeightOutOfBoundsException is thrown when an animal's weight is outside the acceptable range.
 * It extends the Exception class and provides a custom error message indicating the weight is out of bounds.
 */
public final class WeightOutOfBoundsException extends Exception {
    @Override
    public String getMessage() {
        return "The weight is out of bounds";
    }
}
