package design.facade.deliverybox;

public class DeliveryBoxSystem {
  boolean isPaymentSecured() {
    System.out.println("Payment has been secured");
    return true;
  }

  boolean isUserDataValidated() {
    System.out.println("User data has been validated");
    return true;
  }

  void sendNotification() {
    System.out.println("Text message send to the client");
  }
  
  void scheduleDelivery() {
    System.out.println("Delivery is scheduled");
  }
}
