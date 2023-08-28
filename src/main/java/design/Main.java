package design;

import design.builder.classic.BigHouseBuilder;
import design.builder.classic.House;
import design.builder.classic.HouseDirector;
import design.builder.classic.SmallHouseBuilder;
import design.builder.inside.HouseInside;
import design.observer.notification.Email;
import design.observer.notification.MobileApp;
import design.observer.notification.TextMessage;
import design.observer.order.Order;
import design.observer.order.OrderStatus;
import design.singleton.GameEngine;

public class Main {
  public static void main(String[] args) {
    //showObserver();

    //showSingleton();
    boolean isClass = false;
    showBuilder(isClass);
  }

  private static void showObserver() {
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

  private static void showSingleton() {
    GameEngine gameEngine = GameEngine.getInstance();
    GameEngine gameEngine2 = GameEngine.getInstance();
    //Przy porównaniu to jest 2x ten sam obiekt
    System.out.println("Czy to ten sam obiekt:  " + gameEngine.equals(gameEngine2));
  }
  
  private static void showBuilder(boolean isClass) {
    if(isClass) {
      HouseInside houseInside = new HouseInside.HouseBuilder()
          .buildFloors("floors")
          .buildRoof("roof")
          .buildWalls("walls")
          .build();
      System.out.println(houseInside.toString());
    }
    else {
      SmallHouseBuilder smallHouseBuilder = new SmallHouseBuilder();
      BigHouseBuilder bigHouseBuilder = new BigHouseBuilder();
      
      //Lombok ma w sobie @Builder, warto uzyc
      HouseDirector smallHouseDirector = new HouseDirector(smallHouseBuilder);
      HouseDirector bigHouseDirector = new HouseDirector(bigHouseBuilder);
      
      smallHouseDirector.buildHouse();
      bigHouseDirector.buildHouse();
      
      House smallHouseInside = smallHouseDirector.getHouse();
      House bigHouseInside = bigHouseDirector.getHouse();

      System.out.println(smallHouseInside);
      System.out.println(bigHouseInside);
    }
  }
}
