package design.memento.smart_app;

public class SmartAppMemento {
  private Double version;

  SmartAppMemento(Double version) {
    this.version = version;
  }

  public Double getVersion() {
    return this.version;
  }
}
