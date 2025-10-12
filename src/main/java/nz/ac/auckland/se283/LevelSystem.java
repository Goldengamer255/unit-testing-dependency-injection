package nz.ac.auckland.se283;

public class LevelSystem {

  private static final String level1_concept = "Variables";
  private static final String level2_concept = "Operators";
  private static final String level3_concept = "Conditional_Statements";
  private static final String level4_concept = "Loops";
  private static final String level5_concept = "Methods";
  private static final String level6_concept = "Arrays_and_ArrayLists";

  public String getConceptForLevel(int level) {
    if (level == 2) {
      return level2_concept;
    } else if (level == 3) {
      return level3_concept;
    } else if (level == 4) {
      return level4_concept;
    } else if (level == 5) {
      return level5_concept;
    } else if (level == 6) {
      return level6_concept;
    }
    return level1_concept;
  }
}
