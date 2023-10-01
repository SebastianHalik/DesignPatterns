package design.visitor.activity;

import design.visitor.visitors.Visitor;

public interface Activity {
  void accept(Visitor visitor);
}
