package nz.ac.auckland.se283;

public class DistanceSystem {
  private int distance;
  private int degrees;

  public DistanceSystem() {
    this.distance = 5;
    this.degrees = 0;
  }

  public DistanceSystem(int distance, int degrees) {
    if (distance < 1 || distance > 10) {
      this.distance = 5; // specifed default value
    } else {
      this.distance = distance;
    }
    this.degrees = degrees;
  }

  public int getDistance() { // gets distance
    return distance;
  }

  public int getDegrees() { // Changed from Integer to int for consistency
    return degrees;
  }
}
