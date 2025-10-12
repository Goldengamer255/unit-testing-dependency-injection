package nz.ac.auckland.se283;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class LevelSystemTest {

  @Test
  void getConceptForlevel_level1_returnsConditionalStatements() {
    LevelSystem level = new LevelSystem();
    String concept = level.getConceptForLevel(1);
    assertEquals("Variables and Data Types", concept);
  }

  @Test
  void getConceptForlevel_level2_returnsConditionalStatements() {
    LevelSystem level = new LevelSystem();
    String concept = level.getConceptForLevel(2);
    assertEquals("Operators and Expressions", concept);
  }
}
