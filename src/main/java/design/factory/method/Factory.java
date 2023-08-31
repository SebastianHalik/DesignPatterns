package design.factory.method;


import design.factory.UnitType;

public abstract class Factory {

  public abstract Unit createUnit(UnitType unitType);
}
