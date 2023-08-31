package design.flyweight;

public class Rifleman {
  private int x;
  private int y;
  private int hpLeft;
  private UnitStats stats;

  public Rifleman(int x, int y) {
    this.stats = UnitStatsRepository.getRiflemanUnitStats();
    this.x = x;
    this.y = y;
    this.hpLeft = stats.getHp();
  }
}
