package nz.ac.auckland.se283;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

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
  void getConceptForLevel_forEachLevel_returnsExpectedConcept(int currentlevel, String concept) {
    assertEquals(concept, level.getConceptForLevel(currentlevel));
  }

  // @Test
  // void getConceptForLevel_lessThanOne_throwsInvalidLevelException() {
  //   int currentLevel = 0;

  //   assertThrows(InvalidLevelException.class, () -> level.getConceptForLevel(currentLevel));
  // }

  // @Test
  // void getConceptForLevel_moreThanSix_throwsInvalidLevelException() {
  //   int currentLevel = 7;

  //   assertThrows(InvalidLevelException.class, () -> level.getConceptForLevel(currentLevel));
  // }

  @ParameterizedTest(name = "getConceptForLevel_invalidLevel_{0}_throwsInvalidLevelException")
  @ValueSource(ints = {0, 7})
  void getConceptForLevel_invalidLevels_throwsInvalidLevelException(int currentLevel) {
    assertThrows(InvalidLevelException.class, () -> level.getConceptForLevel(currentLevel));
  }
}
