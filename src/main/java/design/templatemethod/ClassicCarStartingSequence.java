package design.templatemethod;

public class ClassicCarStartingSequence extends CarStartingSequence{
  @Override
  public void startIgnition() {
    System.out.println("Start ignition");
  }

  @Override
  public void setGear() {
    System.out.println("Set gear");
  }
}
