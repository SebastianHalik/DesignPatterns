package design;

import design.observer.notification.Email;
import design.observer.notification.MobileApp;
import design.observer.notification.TextMessage;
import design.observer.order.Order;
import design.observer.order.OrderStatus;
import design.singleton.GameEngine;

public class Main {
  public static void main(String[] args) {
    showObserver();
    
    showSingleton();
  }
  private static void showObserver(){
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
  private static void showSingleton(){
    GameEngine gameEngine = GameEngine.getInstance();
    GameEngine gameEngine2 = GameEngine.getInstance();
    //Przy porównaniu to jest 2x ten sam obiekt
    System.out.println("Czy to ten sam obiekt:  " + gameEngine.equals(gameEngine2));
  }
}
