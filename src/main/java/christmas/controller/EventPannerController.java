package christmas.controller;

import christmas.domain.Date;
import christmas.domain.EventBadge;
import christmas.domain.EventBenefit;
import christmas.domain.EventPanner;
import christmas.domain.Menu;
import christmas.domain.OrderMenu;
import christmas.domain.OrderMenus;
import christmas.view.InputView;
import christmas.view.OutputView;
import java.util.ArrayList;
import java.util.List;

public class EventPannerController {
    private final InputView inputView;
    private final OutputView outputView;
    private EventPanner eventPanner;

    public EventPannerController() {
        inputView = new InputView();
        outputView = new OutputView();
    }

    public void reservationOrder() {
        outputView.printEventStartMessage();

        Date date = createDate();
        OrderMenus orderMenus = createOrderMenus();
        eventPanner = new EventPanner(date, orderMenus);

        outputView.printEventBenefitPreview(date.getDay());
    }

    private Date createDate() {
        try {
            int day = inputView.readDate();
            Date date = new Date(day);
            return date;
        } catch (IllegalArgumentException e) {
            outputView.printExceptionMessage(e.getMessage());
            return createDate();
        }
    }

    private OrderMenus createOrderMenus() {
        try {
            List<String> inputMenus = inputView.readMenu();

            List<OrderMenu> orderMenus = new ArrayList<>();
            for (String inputMenu : inputMenus) {
                String[] split = inputMenu.split("-");
                Menu menu = Menu.findMenuBy(split[0]);
                int amount = Integer.parseInt(split[1]);
                orderMenus.add(new OrderMenu(menu, amount));
            }

            return new OrderMenus(orderMenus);
        } catch (IllegalArgumentException e) {
            outputView.printExceptionMessage(e.getMessage());
            return createOrderMenus();
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
