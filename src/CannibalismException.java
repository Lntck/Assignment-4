package src;

public class CannibalismException extends Exception {
  @Override
  public String getMessage() {
    return "Cannibalism is not allowed";
  }
}
