package design;

import design.observer.notification.Email;
import design.observer.notification.MobileApp;
import design.observer.notification.TextMessage;
import design.observer.order.Order;
import design.observer.order.OrderStatus;

public class Main {
  public static void main(String[] args) {
    /*
    OBSERVER
     */
    Order order = new Order(110L, OrderStatus.ZAREJESTROWANE);

    TextMessage textMessage = new TextMessage();
    Email email = new Email();
    MobileApp mobileApp = new MobileApp();
    
    order.registerObserver(textMessage);
    order.registerObserver(email);
    order.registerObserver(mobileApp);
    
    order.notifyObservers();

    System.out.println("------------------------");
    order.changeOrderStatus(OrderStatus.WYSLANE);
    System.out.println("------------------------");
    
    order.unregisterObserver(email);
    order.changeOrderStatus(OrderStatus.ODEBRANE);
  }
}
