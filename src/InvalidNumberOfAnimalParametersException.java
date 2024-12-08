package src;

/**
 * Exception thrown when the number of parameters provided for an animal is invalid.
 */
public final class InvalidNumberOfAnimalParametersException extends Exception {
    @Override
    public String getMessage() {
        return "Invalid number of animal parameters";
    }
}
