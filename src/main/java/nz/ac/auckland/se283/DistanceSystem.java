package nz.ac.auckland.se283;

public class DistanceSystem {
  private int distance;
  private int degrees;
  private UnitConverter unitConverter;

  public DistanceSystem() { // default constructor
    this.distance = 5;
    this.degrees = 0;
  }

  public DistanceSystem(int distance, int degrees) {
    if (distance < 1 || distance > 10) {
      this.distance = 5; // specified default value
    } else {
      this.distance = distance;
    }
    this.degrees = degrees;
    // Removed: this.unitConverter = new UnitConverter();

  }

  // Constructor for dependency injection (used in tests)
  public DistanceSystem(UnitConverter unitConverter) {
    this.distance = 5;
    this.degrees = 0;
    this.unitConverter = unitConverter;
  }

  public DistanceSystem(int distance, int degrees, UnitConverter unitConverter) {
    if (distance < 1 || distance > 10) {
      this.distance = 5;
    } else {
      this.distance = distance;
    }
    this.degrees = degrees;
    this.unitConverter = unitConverter; // Dependency injection
  }

  public int getDistance() { // returns distance value of the object
    return distance;
  }

  public int getDegrees() {
    return degrees;
  }

  public double metersToCentimeters(double meters) {
    return unitConverter.metersToCentimeters(
        meters); // Delegates the conversion to the injected UnitConverter
  }
}
