package design.memento.smart_app;

public class SmartApp {
  private Double version;
  private SmartAppMemento memento;

  public void changeVersion(Double version) {
    this.version = version;
    System.out.println("New version: " + version);
  }

  public SmartAppMemento save() {
    return new SmartAppMemento(this.version);
  }

  public void load(SmartAppMemento memento) {
    this.version = memento.getVersion();
  }
}
