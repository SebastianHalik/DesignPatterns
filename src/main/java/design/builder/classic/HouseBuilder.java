package design.builder.classic;

public interface HouseBuilder {
  void buildWalls();
  void buildFloors();
  void buildRoof();
  void buildWindows();
  void buildDoors();
  void buildGarage();
  void buildRooms();
  
  House getHouse();
}
