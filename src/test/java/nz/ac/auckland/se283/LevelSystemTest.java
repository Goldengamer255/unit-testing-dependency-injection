package nz.ac.auckland.se283;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class LevelSystemTest {

  private LevelSystem level;

  @BeforeEach
  void setUp() {
    level = new LevelSystem();
  }

  @ParameterizedTest(name = "getConceptForlevel{0}_returns{1}")
  @CsvSource({
    "1, Variables",
    "2, Operators",
    "3, Conditional_Statements",
    "4, Loops",
    "5, Methods",
    "6, Arrays_and_ArrayLists"
  })
  void getConceptForLevel_returnsExpectedConcept(int currentlevel, String concept) {
    assertEquals(concept, level.getConceptForLevel(currentlevel));
  }
}
