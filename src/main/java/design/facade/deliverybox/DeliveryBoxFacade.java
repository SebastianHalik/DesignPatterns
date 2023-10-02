package design.facade.deliverybox;

public class DeliveryBoxFacade {
  DeliveryBox deliveryBox;
  DeliveryBoxSystem deliveryBoxSystem;

  public DeliveryBoxFacade() {
    deliveryBox = new DeliveryBox();
    deliveryBoxSystem = new DeliveryBoxSystem();
  }

  public void pickUpPackage() {
    deliveryBox.getUserData();
    if (deliveryBoxSystem.isUserDataValidated() && deliveryBoxSystem.isPaymentSecured()) {
      deliveryBox.openBox();
    }
  }
}
