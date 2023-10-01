package design.visitor.visitors;

import design.visitor.activity.Squash;
import design.visitor.activity.Treadmill;
import design.visitor.activity.Weights;

public class VisitorImpl implements Visitor {
  @Override
  public void visit(Squash squash) {
    System.out.println("Calories burned during Squash:  " + squash.getMinutesPlayed() * 20);
  }

  @Override
  public void visit(Treadmill treadmill) {
    System.out.println("Calories burned during running on Treadmill:  " + treadmill.getDistance() * 3);
  }

  @Override
  public void visit(Weights weights) {
    System.out.println("Calories burned during weights:  " + weights.getWeight() * weights.getReps() * 2);
  }
}
