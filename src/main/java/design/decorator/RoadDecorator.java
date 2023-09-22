package design.decorator;

public class RoadDecorator extends TerrainDecorator{
  public RoadDecorator(Terrain terrain) {
    super(terrain);
  }

  @Override
  public String getDescription() {
    return terrain.getDescription() + " with road.";
  }

  @Override
  public int fuelCost() {
    return terrain.fuelCost() - 10;
  }
}
