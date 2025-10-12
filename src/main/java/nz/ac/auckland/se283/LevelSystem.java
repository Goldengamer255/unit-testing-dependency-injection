package nz.ac.auckland.se283;

public class LevelSystem {

  private static final String level1_concept = "Variables and Data Types";
  private static final String level2_concept = "Operators and Expressions";

  public String getConceptForLevel(int level) {
    if (level == 1) {
      return level1_concept;
    } else if (level == 2) {
      return level2_concept;
    }
    return level1_concept;
  }
}
