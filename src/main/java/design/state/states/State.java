package design.state.states;

import design.state.CoffeeMachine;

public interface State {
  void insertTheCoin(CoffeeMachine coffeeMachine);
  void pushTheButton(CoffeeMachine coffeeMachine);
  void takeTheCup(CoffeeMachine coffeeMachine);
  void returnTheCoin(CoffeeMachine coffeeMachine);
}
