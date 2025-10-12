package nz.ac.auckland.se283;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class DistanceSystemTest {

  @Mock private UnitConverter mockUnitConverter;

  private DistanceSystem distance;

  @BeforeEach
  void setUp() {
    distance = new DistanceSystem();
  }

  @Test
  void getDistance_whenDefault_distanceIsZero() {
    assertAll(
        () ->
            assertEquals(5, distance.getDistance()), // when the distance is default it should be 5
        () -> assertEquals(0, distance.getDegrees()));
  }

  @ParameterizedTest(
      name = "Distance{0}_shouldDefault to 5") // invalid distances -1,0,11 are tested
  @ValueSource(ints = {-1, 0, 11}) // invalid distances
  void setDistance_invalidValues_defaultsToFive(int invalidDistance) {
    DistanceSystem system = new DistanceSystem(invalidDistance, 0);

    int result = system.getDistance();

    assertEquals(5, result);
  }

  @ParameterizedTest(
      name =
          "Distance {0} (boundary) should be set correctly") // testing valid boundary values 1 and
                                                             // 10 so they are set correctly
  @ValueSource(ints = {1, 10})
  void constructor_exactBoundaries_setsCorrectly(int boundaryValue) {
    DistanceSystem system = new DistanceSystem(boundaryValue, 0);

    assertEquals(boundaryValue, system.getDistance());
  }

  @Test
  public void metersToCentimeters_whenCalled_callsConverter() {

    Mockito.when(mockUnitConverter.metersToCentimeters(5.0))
        .thenReturn(500.0); // Mocking behavior this is the test for mock

    DistanceSystem system = new DistanceSystem(mockUnitConverter);

    system.metersToCentimeters(5.0);

    verify(mockUnitConverter, times(1)).metersToCentimeters(5.0);
  }
}
