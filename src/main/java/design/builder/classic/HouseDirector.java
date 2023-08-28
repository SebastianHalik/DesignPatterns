package design.builder.classic;

public class HouseDirector {
  private HouseBuilder houseBuilder;

  public HouseDirector(HouseBuilder houseBuilder) {
    this.houseBuilder = houseBuilder;
  }

  public void buildHouse() {
    houseBuilder.buildWalls();
    houseBuilder.buildFloors();
    houseBuilder.buildDoors();
    houseBuilder.buildRooms();
    houseBuilder.buildGarage();
    houseBuilder.buildRoof();
    houseBuilder.buildWindows();
  }

  public House getHouse() {
    return this.houseBuilder.getHouse();
  }
}
