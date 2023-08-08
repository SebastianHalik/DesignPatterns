package design.singleton;

import java.io.Serial;
import java.io.Serializable;

public class GameEngine implements Serializable {

  @Serial
  private static final long serialVersionUID = 2138;
  private int hp = 100;
  private String name = "";

  private static final GameEngine instance = new GameEngine();

  private GameEngine() {

  }

  public static GameEngine getInstance() {
    return instance;
  }

  protected Object readResolve() {
    return getInstance();
  }

  public void run() {
    while (true) {
      //Czekamy na input gracza
      //zmieniamy stan gry
      //renderujemy grafike
    }
  }
}
