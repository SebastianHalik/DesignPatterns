package design.observer.notification;

import design.observer.order.Order;

public class MobileApp implements Observer {
  public void update(Order order) {
    System.out.println("Aplikacja Mobilna-Zamówienie nr: " + order.getOrderNumber() + " zmieniło status na: " + order.getOrderStatus());
  }
}
