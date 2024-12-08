package src;

public final class EnergyOutOfBoundsException extends Exception {
    @Override
    public String getMessage() {
        return "The energy is out of bounds";
    }
}
