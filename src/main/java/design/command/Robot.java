package design.command;

public class Robot {
  public void turnOn() {
    System.out.println("Robot turned ON!");
  }
  
  public void cut() {
    System.out.println("Robot is cutting!");
  }
  
  public void drill() {
    System.out.println("Robot is drilling!");
  }
  
  public void turnOff() {
    System.out.println("Robot turned OFF!");
  }
}
