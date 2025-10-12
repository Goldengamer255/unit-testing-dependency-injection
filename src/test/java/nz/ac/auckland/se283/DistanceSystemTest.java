package nz.ac.auckland.se283;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class DistanceSystemTest {
  @Test
  void getDistance_whenDefault_distanceIsZero() {
    DistanceSystem distance = new DistanceSystem();

    assertAll(
        () -> assertEquals(5, distance.getDistance()),
        () -> assertEquals(0, distance.getDegrees()));
  }
}
