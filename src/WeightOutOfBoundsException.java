package src;

public class WeightOutOfBoundsException extends Exception {
    @Override
    public String getMessage() {
        return "The weight is out of bounds";
    }
}
