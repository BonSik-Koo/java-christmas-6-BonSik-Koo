package christmas.controller;

import christmas.domain.Date;
import christmas.domain.EventBadge;
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
        Date date = inputVisitDate();
        List<MenuInfo> menus = inputOrderMenuInfo();
        eventPanner = new EventPanner(date, menus);
        outputView.printEventBenefitPreview(date.getDay());
    }

    private Date inputVisitDate() {
        outputView.printEventStartMessage();
        try {
            int day = inputView.readDate();
            return new Date(day);
        } catch (IllegalArgumentException e) {
            outputView.printExceptionMessage(e.getMessage());
            return inputVisitDate();
        }
    }

    private List<MenuInfo> inputOrderMenuInfo() {
        try {
            return inputView.readMenu();
        } catch (IllegalArgumentException e) {
            outputView.printExceptionMessage(e.getMessage());
            return inputOrderMenuInfo();
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
        EventBadge badge = eventPanner.getBadge();
        outputView.printEventBadge(badge.getName());
    }

}