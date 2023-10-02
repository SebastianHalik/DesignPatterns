package design.state.states;

import design.state.CoffeeMachine;

public class CupFullState implements State{
  @Override
  public void insertTheCoin(CoffeeMachine coffeeMachine) {
    System.out.println("Take cup first!");
  }

  @Override
  public void pushTheButton(CoffeeMachine coffeeMachine) {
    System.out.println("Take cup first!");
  }

  @Override
  public void takeTheCup(CoffeeMachine coffeeMachine) {
    System.out.println("Cup taken!");
    coffeeMachine.state = new NoCoinState();
  }

  @Override
  public void returnTheCoin(CoffeeMachine coffeeMachine) {
    System.out.println("Too late!");
  }
}
