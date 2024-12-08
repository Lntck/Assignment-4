package src;

/**
 * The TooStrongPreyException is thrown when a predator attempts to attack a prey that is too strong or too fast.
 * It extends the Exception class and provides a custom error message.
 */
public final class TooStrongPreyException extends Exception {
    @Override
    public String getMessage() {
        return "The prey is too strong or too fast to attack";
    }
}
