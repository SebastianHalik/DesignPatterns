package design.command.command.robot;

import design.command.Robot;
import design.command.command.Command;

public class RobotDrillCommand implements Command {
  private Robot robot;

  public RobotDrillCommand(Robot robot) {
    this.robot = robot;
  }

  @Override
  public void execude() {
    robot.drill();
  }

  @Override
  public void undo() {
    System.out.println("Undo Drill");
  }
}
