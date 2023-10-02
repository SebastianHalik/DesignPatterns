package design;

import design.adapter.*;
import design.builder.classic.BigHouseBuilder;
import design.builder.classic.House;
import design.builder.classic.HouseDirector;
import design.builder.classic.SmallHouseBuilder;
import design.builder.inside.HouseInside;
import design.chainofresponsibility.message.Message;
import design.chainofresponsibility.officer.*;
import design.command.Robot;
import design.command.WorkShopApp;
import design.command.command.robot.RobotCutCommand;
import design.command.command.robot.RobotDrillCommand;
import design.command.command.robot.RobotTurnOffCommand;
import design.command.command.robot.RobotTurnOnCommand;
import design.command.command.coffeemaker.CoffeeMaker;
import design.command.command.coffeemaker.CoffeeMakerTurnOffCommand;
import design.command.command.coffeemaker.CoffeeMakerTurnOnCommand;
import design.decorator.*;
import design.factory.UnitType;
import design.factory.abstraction.*;
import design.factory.method.Factory;
import design.factory.method.Unit;
import design.factory.method.UnitFactory;
import design.flyweight.TeslaTank;
import design.memento.smart_app.SmartApp;
import design.memento.smart_app.SmartAppCaretaker;
import design.observer.notification.Email;
import design.observer.notification.MobileApp;
import design.observer.notification.TextMessage;
import design.observer.order.Order;
import design.observer.order.OrderStatus;
import design.singleton.GameEngine;
import design.state.CoffeeMachine;
import design.strategy.Chef;
import design.strategy.egg_cooker.HardBoiledEggCooker;
import design.strategy.egg_cooker.SoftBoiledEggCooker;
import design.templatemethod.AutomaticCarStartingSequence;
import design.visitor.activity.Squash;
import design.visitor.activity.Treadmill;
import design.visitor.activity.Weights;
import design.visitor.visitors.VisitorImpl;

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

    //showFlyweight();

    //showAdapter();

    //showDecorator();

    //showChainOfResponsibility();

    //showTemplateMethod();

    //showCommand();
    
    //showMemento();

    //showStrategy();
    
    //showVisitor();
    
    showState();
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
    System.out.println("Time measure in seconds: " + elapsedTime / 1000F);
    System.out.println("Time measure in minutes: " + elapsedTime / (60 * 1000F));
  }

  private static void showAdapter() {
    ContinentalSocket continentalSocket = new ContinentalSocket();
    UKSocket ukSocket = new UKSocket();
    UKDevice ukRadio = new UKDevice() {
      @Override
      public void powerOn() {
        System.out.println("English music plays in background");
      }
    };

    ContinentalDevice continentalRadio = new ContinentalDevice() {
      @Override
      public void on() {
        System.out.println("European music plays in background");
      }
    };
    TwoWayAdapter adapter = new TwoWayAdapter(ukRadio, continentalRadio);
    continentalSocket.plugIn(adapter);
    ukSocket.plugIn(adapter);
  }

  private static void showDecorator() {
    Terrain terrain = new SwampDecorator(new Hill());
    Terrain terrain1 = new SwampDecorator(new ForestDecorator(new Plain()));
    System.out.println("Swamp hill cost " + terrain.fuelCost() + " and should be: 50"); //45
    System.out.println("Swamp forest plain cost " + terrain1.fuelCost() + " and should be: 33"); //33
  }

  private static void showChainOfResponsibility() {
    Message message = new Message("ATTACK!", 20, OfficerRank.CAPTAIN);
    Officer sergeant = new Sergeant();
    Officer captain = new Captain();
    Officer general = new General();

    sergeant.setSuperiorOfficer(captain);
    captain.setSuperiorOfficer(general);

    sergeant.processMessage(message);
  }

  private static void showTemplateMethod() {
    AutomaticCarStartingSequence automaticCarStartingSequence = new AutomaticCarStartingSequence();
    automaticCarStartingSequence.startCar();
  }

  private static void showCommand() {
    Robot robot = new Robot();
    WorkShopApp workShopApp = new WorkShopApp();
    workShopApp.addToQueue(new RobotTurnOnCommand(robot));
    workShopApp.addToQueue(new RobotCutCommand(robot));
    workShopApp.addToQueue(new RobotDrillCommand(robot));
    workShopApp.addToQueue(new RobotTurnOffCommand(robot));

    CoffeeMaker coffeeMaker = new CoffeeMaker();
    workShopApp.addToQueue(new CoffeeMakerTurnOnCommand(coffeeMaker));
    workShopApp.addToQueue(new CoffeeMakerTurnOffCommand(coffeeMaker));
    
    workShopApp.undoLastCommand();
    
    workShopApp.run();
  }
  
  private static void showMemento() {
    SmartAppCaretaker smartAppCaretaker = new SmartAppCaretaker();
    SmartApp smartApp = new SmartApp();
    
    smartApp.changeVersion(1.0);
    smartApp.changeVersion(1.1);
    smartApp.changeVersion(1.2);
    
    smartAppCaretaker.addMemento(smartApp.save());
    
    smartApp.changeVersion(1.3);
    smartApp.changeVersion(2.0);
    smartApp.changeVersion(2.1);
    
    smartApp.load(smartAppCaretaker.getMemento(0));
  }
  
  private static void showStrategy() {
    Chef chef = new Chef("Robert Makłowicz");
    
    chef.setEggCooker(new HardBoiledEggCooker());
    chef.cook();

    chef.setEggCooker(new SoftBoiledEggCooker());
    chef.cook();
  }

  private static void showVisitor() {
    Treadmill treadmill = new Treadmill(200);
    Squash squash = new Squash(90);
    Weights weights = new Weights(70,15);

    VisitorImpl visitor = new VisitorImpl();
    
    treadmill.accept(visitor);
    squash.accept(visitor);
    weights.accept(visitor);
  }
  
  private static void showState() {
    CoffeeMachine coffeeMachine = new CoffeeMachine();
    
    coffeeMachine.insertCoin();
    coffeeMachine.pushTheButton();
    coffeeMachine.takeTheCup();
    coffeeMachine.returnTheCoin();
  }
}
