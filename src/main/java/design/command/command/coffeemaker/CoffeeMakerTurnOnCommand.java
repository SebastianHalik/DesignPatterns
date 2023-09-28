package design.command.command.coffeemaker;

import design.command.command.Command;

public class CoffeeMakerTurnOnCommand implements Command {
  private final CoffeeMaker coffeeMaker;

  public CoffeeMakerTurnOnCommand(CoffeeMaker coffeeMaker) {
    this.coffeeMaker = coffeeMaker;
  }

  @Override
  public void execude() {
    coffeeMaker.turnOn();
  }

  @Override
  public void undo() {
    coffeeMaker.turnOff();
  }
}
