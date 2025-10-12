package nz.ac.auckland.se283;

public class InvalidLevelException extends RuntimeException {

  public InvalidLevelException(int level, int minLevel, int maxLevel) {
    super("Level must be between 1 and 6 inclusive");
  }
}
