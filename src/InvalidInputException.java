package src;

public final class InvalidInputException extends Exception {
    @Override
    public String getMessage() {
        return "Invalid inputs";
    }
}
