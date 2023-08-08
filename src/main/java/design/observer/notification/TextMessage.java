package design.observer.notification;

import design.observer.order.Order;

public class TextMessage implements Observer {
  public void update(Order order) {
    System.out.println("SMS-Zamówienie nr: " + order.getOrderNumber() + " zmieniło status na: " + order.getOrderStatus());
  }
}
