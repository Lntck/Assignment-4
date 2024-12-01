package src;

public class SelfHuntingException extends Exception {
    @Override
    public String getMessage() {
        return "Self-hunting is not allowed";
    }
}
