package design.memento.smart_app;

import java.util.ArrayList;
import java.util.List;

public class SmartAppCaretaker {
  List<SmartAppMemento> mementos = new ArrayList<>();

  public void addMemento(SmartAppMemento memento) {
    mementos.add(memento);
    System.out.println("Saved version:  " + memento.getVersion() + " index: " + (mementos.size() - 1));
  }

  public SmartAppMemento getMemento(int index) {
    System.out.println("Loaded version: " + mementos.get(index).getVersion());
    return mementos.get(index);
  }
}
