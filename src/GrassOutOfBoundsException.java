package src;

public final class GrassOutOfBoundsException extends Exception {
    @Override
    public String getMessage() {
        return "The grass is out of bounds";
    }
}
