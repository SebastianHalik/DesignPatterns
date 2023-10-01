package design.visitor.visitors;

import design.visitor.activity.Squash;
import design.visitor.activity.Treadmill;
import design.visitor.activity.Weights;

public interface Visitor {
  void visit(Squash squash);
  void visit(Treadmill treadmill);
  void visit(Weights weights);
}
