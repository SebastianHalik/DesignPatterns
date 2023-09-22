package design.templatemethod;

public class AutomaticCarStartingSequence extends ClassicCarStartingSequence {
  @Override
  public void setGear() {
    System.out.println("Automatic set gear");
  }
}
