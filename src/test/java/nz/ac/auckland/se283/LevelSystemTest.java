package nz.ac.auckland.se283;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class LevelSystemTest {

  @Test
  void getConceptForlevel_level1Difficulty3_returnsConditionalStatements() {
    LevelSystem ls = new LevelSystem();
    String concept = ls.getConceptForLevel(1);
    assertEquals("Variables and Data Types", concept);
  }
}
