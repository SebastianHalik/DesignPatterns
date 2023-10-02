package design.state.states;

import design.state.CoffeeMachine;

public class NoCoinState implements State{
  @Override
  public void insertTheCoin(CoffeeMachine coffeeMachine) {
    System.out.println("Thank you for coin");
    coffeeMachine.state = new CoinInsertedState();
  }

  @Override
  public void pushTheButton(CoffeeMachine coffeeMachine) {
    System.out.println("Insert coin");
  }

  @Override
  public void takeTheCup(CoffeeMachine coffeeMachine) {
    System.out.println("Insert coin");
  }

  @Override
  public void returnTheCoin(CoffeeMachine coffeeMachine) {
    System.out.println("Insert coin");
  }
}
