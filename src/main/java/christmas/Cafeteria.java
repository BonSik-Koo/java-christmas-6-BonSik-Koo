package christmas;

import christmas.controller.EventController;

public class Cafeteria {
    private final EventController eventController;

    public Cafeteria() {
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
