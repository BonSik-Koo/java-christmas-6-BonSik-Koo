package christmas.controller;

import christmas.domain.Date;
import christmas.domain.EventBenefit;
import christmas.domain.EventPanner;
import christmas.domain.OrderMenus;
import christmas.dto.MenuInfo;
import christmas.view.InputView;
import christmas.view.OutputView;
import java.util.List;

public class EventController {
    private final InputView inputView;
    private final OutputView outputView;
    private EventPanner eventPanner;

    public EventController() {
        inputView = new InputView();
        outputView = new OutputView();
    }

    public void participate() {
        Date date = createDate();
        OrderMenus orderMenus = createOrderMenu();
        eventPanner = new EventPanner(date, orderMenus);

        outputView.printEventBenefitPreview(date.getDay());
    }

    private Date createDate() {
        outputView.printEventStartMessage();
        try {
            int day = inputView.readDate();
            return new Date(day);
        } catch (IllegalArgumentException e) {
            outputView.printExceptionMessage(e.getMessage());
            return createDate();
        }
    }

    private OrderMenus createOrderMenu() {
        try {
            List<MenuInfo> menuInfos = inputView.readMenu();
            return new OrderMenus(menuInfos);
        } catch (IllegalArgumentException e) {
            outputView.printExceptionMessage(e.getMessage());
            return createOrderMenu();
        }
    }

    public void readOrderInfo() {
        OrderMenus orderMenus = eventPanner.getOrderMenus();
        outputView.printOrderInfo(orderMenus);
    }

    public void readBenefitInfo() {
        EventBenefit eventBenefit = eventPanner.getEventBenefit();
        outputView.printBenefitInfo(eventBenefit);
    }

    public void readPaymentInfo() {
        int paymentPrice = eventPanner.getPaymentPrice();
        outputView.printPaymentPrice(paymentPrice);
    }

    public void readBadgeInfo() {
        String eventBadge = eventPanner.getBadge();
        outputView.printEventBadge(eventBadge);
    }

}
