package design.command.command.coffeemaker;

import design.command.command.Command;

public class CoffeeMakerTurnOffCommand implements Command {
  private final CoffeeMaker coffeeMaker;

  public CoffeeMakerTurnOffCommand(CoffeeMaker coffeeMaker) {
    this.coffeeMaker = coffeeMaker;
  }

  @Override
  public void execude() {
    coffeeMaker.turnOff();
  }

  @Override
  public void undo() {
    coffeeMaker.turnOn();
  }
}
