package christmas;

import christmas.controller.EventController;

public class Application {
    public static void main(String[] args) {
        EventController eventPannerController = new EventController();

        eventPannerController.participate();
        eventPannerController.readOrderInfo();
        eventPannerController.readBenefitInfo();
        eventPannerController.readPaymentInfo();
        eventPannerController.readBadgeInfo();
    }
}
