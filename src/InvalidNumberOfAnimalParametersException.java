package src;

public final class InvalidNumberOfAnimalParametersException extends Exception {
    @Override
    public String getMessage() {
        return "Invalid number of animal parameters";
    }
}
