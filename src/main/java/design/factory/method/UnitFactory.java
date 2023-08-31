package design.factory.method;


import design.factory.UnitType;

public class UnitFactory extends Factory{
  @Override
  public Unit createUnit(UnitType unitType) {
    return switch (unitType) {
      case TANK -> new Tank(200, 0, 20);
      case RIFLEMAN -> new Rifleman(100, 0, 10);
      default -> throw new UnsupportedOperationException("No such type");
    };
  }
}
