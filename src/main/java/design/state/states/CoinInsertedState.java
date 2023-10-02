package design.state.states;

import design.state.CoffeeMachine;

public class CoinInsertedState implements State {
  @Override
  public void insertTheCoin(CoffeeMachine coffeeMachine) {
    System.out.println("You already has coin, choose coffee!");
  }

  @Override
  public void pushTheButton(CoffeeMachine coffeeMachine) {
    System.out.println("I serve coffee");
    coffeeMachine.state = new CupFullState();
  }

  @Override
  public void takeTheCup(CoffeeMachine coffeeMachine) {
    System.out.println("Push button");
  }

  @Override
  public void returnTheCoin(CoffeeMachine coffeeMachine) {
    System.out.println("I return coin");
    coffeeMachine.state = new NoCoinState();
  }
}
