package design.command;

import design.command.command.Command;

import java.util.ArrayList;
import java.util.List;

public class WorkShopApp {

  private final List<Command> commandQueue = new ArrayList<>();

  public void addToQueue(Command command) {
    commandQueue.add(command);
  }

  public void run() {
    if (commandQueue.isEmpty()) {
      System.out.println("Command Queue is empty!");
    }
    for (Command command : commandQueue) {
      command.execude();
    }
    commandQueue.clear();
  }
  
  public void undoLastCommand() {
    //Works only if you are not clearing list in run method
    for (Command command : commandQueue) {
      command.undo();
    }
  }
}
