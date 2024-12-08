package src;

public final class TooStrongPreyException extends Exception {
    @Override
    public String getMessage() {
        return "The prey is too strong or too fast to attack";
    }
}
