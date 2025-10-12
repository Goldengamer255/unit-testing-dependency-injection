package nz.ac.auckland.se283;

import static org.junit.jupiter.api.Assertions.assertEquals; // for assertions in tests
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach; // setup method before each test
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

public class LevelSystemTest {

  private LevelSystem level;

  @BeforeEach
  void setUp() {
    level = new LevelSystem();
  }

  @ParameterizedTest(
      name = "getConceptForlevel{0}_returns{1}") // parameterized test for all valid levels
  @CsvSource({
    "1, Variables",
    "2, Operators",
    "3, Conditional_Statements",
    "4, Loops",
    "5, Methods",
    "6, Arrays_and_ArrayLists"
  })
  void getConceptForLevel_forEachLevel_returnsExpectedConcept(int currentlevel, String concept) {
    assertEquals(concept, level.getConceptForLevel(currentlevel));
  }

  @ParameterizedTest(
      name =
          "getConceptForLevel_invalidLevel_{0}_throwsInvalidLevelException") // testing invalid
                                                                             // levels -1,0,7 and 8
  @ValueSource(ints = {0, 7})
  void getConceptForLevel_invalidLevels_throwsInvalidLevelException(int currentLevel) {
    assertThrows(
        InvalidLevelException.class,
        () ->
            level.getConceptForLevel(
                currentLevel)); // expects exception to be thrown for invalid levels
  }

  @Test
  void getAllConcepts_whenCalled_returnsAllConcepts() {
    assertEquals(
        "Variables, Operators,"
            + " Conditional_Statements,"
            + " Loops, Methods,"
            + " Arrays_and_ArrayLists", // expects this exact string when getAllConcepts is called
        level.getAllConcepts());
  }

  @Test
  void getAllConcepts_whenAllLevelsDifferent_returnsTrue() {
    assertEquals(true, level.checkIfDifferent());
  }
}
