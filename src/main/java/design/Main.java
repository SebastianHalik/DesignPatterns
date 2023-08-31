package design;

import design.builder.classic.BigHouseBuilder;
import design.builder.classic.House;
import design.builder.classic.HouseDirector;
import design.builder.classic.SmallHouseBuilder;
import design.builder.inside.HouseInside;
import design.factory.UnitType;
import design.factory.abstraction.*;
import design.factory.method.Factory;
import design.factory.method.Unit;
import design.factory.method.UnitFactory;
import design.flyweight.TeslaTank;
import design.observer.notification.Email;
import design.observer.notification.MobileApp;
import design.observer.notification.TextMessage;
import design.observer.order.Order;
import design.observer.order.OrderStatus;
import design.singleton.GameEngine;

import java.util.ArrayList;
import java.util.List;

public class Main {
  public static void main(String[] args) {
    //showObserver();

    //showSingleton();
    
    /*
    boolean isClass = false;
    showBuilder(isClass);
     */
    
    /*
    boolean isMethod = false;
    showFactory(isMethod);
     */

    showFlyweight();
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
    if (isClass) {
      HouseInside houseInside = new HouseInside.HouseBuilder()
          .buildFloors("floors")
          .buildRoof("roof")
          .buildWalls("walls")
          .build();
      System.out.println(houseInside.toString());
    } else {
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

  private static void showFactory(boolean isMethod) {
    if (isMethod) {
      Factory factory = new UnitFactory();
      Unit tank = factory.createUnit(UnitType.TANK);
      Unit rifleman = factory.createUnit(UnitType.RIFLEMAN);
      System.out.println("Tank:  " + tank);
      System.out.println("Rifleman:  " + rifleman);
    } else {
      AbstractFactory blueFactory = new BlueFactory();
      AbstractFactory redFactory = new RedFactory();

      MechanizedUnit blueTank = blueFactory.createMechanizedUnit(UnitType.TANK);
      InfantryUnit redRifleman = redFactory.createInfantryUnit(UnitType.RIFLEMAN);
      AirUnit blueHelicopter = blueFactory.createAirUnit(UnitType.HELICOPTER);

      System.out.println("blueTank:  " + blueTank);
      System.out.println("redRifleman:  " + redRifleman);
      System.out.println("blueHelicopter:  " + blueHelicopter);
    }
  }

  private static void showFlyweight() {
    long start = System.currentTimeMillis();
    List<Object> activeUnits = new ArrayList<>();
    for (int i = 0; i < 10000000; i++) {
      activeUnits.add(new TeslaTank(0, 0));
      activeUnits.add(new TeslaTank(0, 0));
    }
    long elapsedTime = System.currentTimeMillis() - start;
    System.out.println("Time measure in seconds: " + elapsedTime/1000F);
    System.out.println("Time measure in minutes: " + elapsedTime/(60 *1000F));
  }
}
