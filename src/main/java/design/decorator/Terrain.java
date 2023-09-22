package design.decorator;

public abstract class Terrain {
  private String description;
  private int fuelCost;

  public Terrain(String description, int fuelCost) {
    this.description = description;
    this.fuelCost = fuelCost;
  }

  public String getDescription() {
    return description;
  }

  public int fuelCost() {
    return fuelCost;
  }
}
