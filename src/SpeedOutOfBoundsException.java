package src;

public final class SpeedOutOfBoundsException extends Exception {
    @Override
    public String getMessage() {
        return "The speed is out of bounds";
    }
}
