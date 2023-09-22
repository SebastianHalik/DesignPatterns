package design.templatemethod;

public abstract class CarStartingSequence {
  public final void startCar() {
    fastenSeatBelts();
    startIgnition();
    setGear();
    go();
  }
  
  private void fastenSeatBelts() {
    System.out.println("fastenSeatBelts");
  }
  
  private void go() {
    System.out.println("GO");
  }
  
  public abstract void startIgnition();
  public abstract void setGear();
}
