package design.factory.abstraction;

import design.factory.UnitType;

public class BlueFactory extends AbstractFactory {
  /*
Podział na Red i Blue -> 2 zespoły walczące w Grze
 */
  @Override
  public InfantryUnit createInfantryUnit(UnitType unitType) {
    return switch (unitType) {
      case RIFLEMAN -> new Rifleman(25, 0, 5);
      default -> throw new UnsupportedOperationException("No such type");
    };
  }

  @Override
  public MechanizedUnit createMechanizedUnit(UnitType unitType) {
    return switch (unitType) {
      case TANK -> new Tank(100, 0, 10);
      default -> throw new UnsupportedOperationException("No such type");
    };
  }

  @Override
  public AirUnit createAirUnit(UnitType unitType) {
    return switch (unitType) {
      case HELICOPTER -> new Helicopter(70, 0, 15);
      default -> throw new UnsupportedOperationException("No such type");
    };
  }
}
