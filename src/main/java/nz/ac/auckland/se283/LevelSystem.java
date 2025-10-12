package nz.ac.auckland.se283;

public class LevelSystem {

  private static final String level1_concept = "Variables and Data Types";
  private static final String level2_concept = "Operators and Expressions";
  private static final String level3_concept = "Conditional Statements";
  private static final String level4_concept = "Loops";
  private static final String level5_concept = "Methods";

  public String getConceptForLevel(int level) {
    if (level == 2) {
      return level2_concept;
    } else if (level == 3) {
      return level3_concept;
    } else if (level == 4) {
      return level4_concept;
    } else if (level == 5) {
      return level5_concept;
    }
    return level1_concept;
  }
}
