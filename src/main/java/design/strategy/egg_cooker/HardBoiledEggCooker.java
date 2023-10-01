package design.strategy.egg_cooker;

public class HardBoiledEggCooker implements EggCooker{
  @Override
  public void cookEgg() {
    System.out.println("I cook HARD boiled egg");
  }
}
