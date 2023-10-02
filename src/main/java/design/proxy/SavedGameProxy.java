package design.proxy;

public class SavedGameProxy implements SavedGame {
  private SavedGame savedGame;
  private String name;

  @Override
  public void initialize() {
    this.name = "Save game - " + System.currentTimeMillis();
  }

  @Override
  public void loadGame() {
    savedGame = new SavedGameFull();
    savedGame.initialize();
    savedGame.loadGame();
  }

  @Override
  public String getName() {
    return this.name;
  }
}
