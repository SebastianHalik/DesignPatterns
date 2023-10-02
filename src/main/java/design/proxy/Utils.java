package design.proxy;

import java.util.ArrayList;
import java.util.List;

public class Utils {
  private Utils() {
  }

  public static List<SavedGame> loadSavedGames() {
    int savedGamesCount = 10;
    List<SavedGame> savedGames = new ArrayList<>(savedGamesCount);
    for (int i = 0; i < 20; i++) {
      SavedGame sg = new SavedGameProxy();
      sg.initialize();
      savedGames.add(sg);
    }
    return savedGames;
  }

  public static void listSavedGames(List<SavedGame> list) {
    for (SavedGame savedGame : list) {
      System.out.println(savedGame.getName());
    }
  }
}
