package christmas;

import christmas.controller.EventController;

public class WoowaCafeteria {
    private final EventController eventController;

    public WoowaCafeteria() {
        eventController = new EventController();
    }

    public void startEvent() {
        eventController.participate();
        eventController.readOrderInfo();
        eventController.readBenefitInfo();
        eventController.readPaymentInfo();
        eventController.readBadgeInfo();
    }

}
