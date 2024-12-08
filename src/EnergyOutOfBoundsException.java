package src;

/**
 * Exception thrown when an animal's energy is out of the valid bounds.
 * This occurs when an animal's energy value is outside the predefined range
 * of acceptable energy values.
 */
public final class EnergyOutOfBoundsException extends Exception {
    @Override
    public String getMessage() {
        return "The energy is out of bounds";
    }
}
