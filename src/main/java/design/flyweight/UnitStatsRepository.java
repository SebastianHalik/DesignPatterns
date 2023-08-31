package design.flyweight;

public class UnitStatsRepository {
  private static final UnitStats destroyerUnitStats = new UnitStats("Destroyer", 500, 10, 0, 5, 20);
  private static final UnitStats riflemanUnitStats = new UnitStats("Rifleman", 100, 3, 0, 2, 5);
  private static final UnitStats teslaTankUnitStats = new UnitStats("TeslaTank", 700, 30, 0, 4, 25);
  private UnitStatsRepository(){}
  public static UnitStats getDestroyerStats() {
    return destroyerUnitStats;
  }
  public static UnitStats getRiflemanUnitStats() {
    return riflemanUnitStats;
  }

  public static UnitStats getTeslaTankStats() {
    return teslaTankUnitStats;
  }
}
