package design.factory.abstraction;


import design.factory.UnitType;

public abstract class AbstractFactory {
  public abstract InfantryUnit createInfantryUnit(UnitType unitType);

  public abstract MechanizedUnit createMechanizedUnit(UnitType unitType);
  public abstract AirUnit createAirUnit(UnitType unitType);
}
