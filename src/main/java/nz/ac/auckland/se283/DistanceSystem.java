package nz.ac.auckland.se283;

public class DistanceSystem {
  private int distance;
  private int degrees;

  public DistanceSystem() {
    this.distance = 5;
    this.degrees = 0;
  }

  public DistanceSystem(int distance, int degrees) {
    this.distance = distance;
    this.degrees = degrees;
  }

  public int getDistance() {
    return distance;
  }

  public Integer getDegrees() {
    return degrees;
  }
}
