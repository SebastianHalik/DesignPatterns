package design.chainofresponsibility.officer;

import design.chainofresponsibility.message.Message;

public class Captain extends Officer {
  private static final int CODE = 20;
  private static final String NAME = "Captain";

  @Override
  public void processMessage(Message message) {
    if (message.getOfficerRank().equals(OfficerRank.CAPTAIN) && message.getCode() == CODE) {
      System.out.println(NAME + " received message: " + message.getContent());
    } else {
      getSuperiorOfficer().processMessage(message);
    }
  }
}
