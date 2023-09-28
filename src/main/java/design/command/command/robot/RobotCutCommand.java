package design.command.command.robot;

import design.command.Robot;
import design.command.command.Command;

public class RobotCutCommand implements Command {
  private Robot robot;

  public RobotCutCommand(Robot robot) {
    this.robot = robot;
  }

  @Override
  public void execude() {
    robot.cut();
  }

  @Override
  public void undo() {
    System.out.println("Undo cut");
  }
}
