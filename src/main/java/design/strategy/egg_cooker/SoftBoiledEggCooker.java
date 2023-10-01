package design.strategy.egg_cooker;

public class SoftBoiledEggCooker implements EggCooker{
  @Override
  public void cookEgg() {
    System.out.println("I cook SOFT boiled egg");
  }
}
