package src;

/**
 * Exception thrown when there are invalid inputs in the program, indicating that the provided data is not correct.
 */
public final class InvalidInputException extends Exception {
    @Override
    public String getMessage() {
        return "Invalid inputs";
    }
}
