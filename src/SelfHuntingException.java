package src;

/**
 * The SelfHuntingException is thrown when an animal attempts to hunt itself, which is not allowed.
 * It extends the Exception class and provides a custom error message.
 */
public final class SelfHuntingException extends Exception {
    @Override
    public String getMessage() {
        return "Self-hunting is not allowed";
    }
}
