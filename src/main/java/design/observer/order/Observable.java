package design.observer.order;

import design.observer.notification.Observer;

public interface Observable {
  void registerObserver(Observer observer);
  void unregisterObserver(Observer observer);
  void notifyObservers();
}
