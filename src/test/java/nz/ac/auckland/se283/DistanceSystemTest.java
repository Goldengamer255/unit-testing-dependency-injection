package nz.ac.auckland.se283;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class DistanceSystemTest {

  private DistanceSystem distance;

  @BeforeEach
  void setUp() {
    distance = new DistanceSystem();
  }

  @Test
  void getDistance_whenDefault_distanceIsZero() {

    assertAll(
        () -> assertEquals(5, distance.getDistance()),
        () -> assertEquals(0, distance.getDegrees()));
  }

  @ParameterizedTest(name = "Distance{0}_shouldDefault to 5")
  @ValueSource(ints = {-1, 0, 11}) // invalid distances
  void setDistance_invalidValues_defaultsToFive(int invalidDistance) {
    DistanceSystem system = new DistanceSystem(invalidDistance, 0);

    int result = system.getDistance();

    assertEquals(5, result);
  }
}
