package design.chainofresponsibility.officer;

import design.chainofresponsibility.message.Message;

public class General extends Officer {
  private static final int CODE = 30;
  private static final String NAME = "General";

  @Override
  public void processMessage(Message message) {
    if (message.getOfficerRank().equals(OfficerRank.GENERAL) && message.getCode() == CODE) {
      System.out.println(NAME + " received message: " + message.getContent());
    } else {
      System.out.println("Wrong code or receiver");
    }
  }
}
