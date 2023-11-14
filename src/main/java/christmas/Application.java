package christmas;

import christmas.controller.EventPannerController;

public class Application {
    public static void main(String[] args) {
        EventPannerController eventPannerController = new EventPannerController();
        eventPannerController.reservationOrder();
        eventPannerController.readOrderInfo();
        eventPannerController.readBenefitInfo();
        eventPannerController.readPaymentInfo();
        eventPannerController.readBadgeInfo();
    }
}
