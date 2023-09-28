package design.command.command.robot;

import design.command.Robot;
import design.command.command.Command;

public class RobotTurnOffCommand implements Command {
  private Robot robot;

  public RobotTurnOffCommand(Robot robot) {
    this.robot = robot;
  }

  @Override
  public void execude() {
    robot.turnOff();
  }

  @Override
  public void undo() {
    robot.turnOn();
  }
}
