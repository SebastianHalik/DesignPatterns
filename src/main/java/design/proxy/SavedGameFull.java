package design.proxy;

import static java.lang.Thread.sleep;

public class SavedGameFull implements SavedGame {
  private String name;
  private String gameData;

  @Override
  public void initialize() {
    this.name = "Saved Game - " + System.currentTimeMillis();
    this.gameData = loadFromStorage();
  }

  private String loadFromStorage() {
    try {
      sleep(500);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    return "Loaded";
  }

  @Override
  public void loadGame() {
    System.out.println("Game loaded");
  }

  @Override
  public String getName() {
    return this.name;
  }
}
