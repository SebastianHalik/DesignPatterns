package design.observer.notification;

import design.observer.order.Order;

public interface Observer {
  void update(Order order);
}
