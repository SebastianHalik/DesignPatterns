package design.state;

import design.state.states.NoCoinState;
import design.state.states.State;

public class CoffeeMachine {
  public State state;

  public CoffeeMachine() {
    state = new NoCoinState();
  }

  public void pushTheButton() {
    state.pushTheButton(this);
  }

  public void takeTheCup() {
    state.takeTheCup(this);
  }

  public void insertCoin() {
    state.insertTheCoin(this);
  }

  public void returnTheCoin() {
    state.returnTheCoin(this);
  }
}
