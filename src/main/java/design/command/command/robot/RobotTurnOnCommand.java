package design.command.command.robot;

import design.command.Robot;
import design.command.command.Command;

public class RobotTurnOnCommand implements Command {
  private Robot robot;

  public RobotTurnOnCommand(Robot robot) {
    this.robot = robot;
  }

  @Override
  public void execude() {
    robot.turnOn();
  }

  @Override
  public void undo() {
    robot.turnOff();
  }
}
