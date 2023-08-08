package design.observer.notification;

import design.observer.order.Order;

public class Email implements Observer{
  public void update(Order order) {
    System.out.println("EMAIL-Zamówienie nr: " + order.getOrderNumber() + " zmieniło status na: " + order.getOrderStatus());
  }
}
