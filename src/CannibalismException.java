package src;

/**
 * Exception thrown when an animal attempts to hunt another animal of the same species.
 * Represents a scenario of cannibalism, which is not permitted in the simulation.
 */
public final class CannibalismException extends Exception {
  @Override
  public String getMessage() {
    return "Cannibalism is not allowed";
  }
}
