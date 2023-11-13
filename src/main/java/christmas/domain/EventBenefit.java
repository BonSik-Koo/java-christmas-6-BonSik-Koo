package christmas.domain;

import java.util.List;

public class EventBenefit {
    private final static int PRESENT_MENU_STANDARD_PRICE = 120000;
    private final List<EventDiscount> eventDiscounts;
    private final Menu presentMenu;

    public EventBenefit(Date date, OrderMenus orderMenus) {
        this.eventDiscounts = EventDiscountClassifier.generateEventBenefits(date, orderMenus);
        this.presentMenu = determinePresentMenu(orderMenus);
    }

    private Menu determinePresentMenu(OrderMenus orderMenus) {
        int totalOrderPrice = orderMenus.calculateTotalPrice();
        if (totalOrderPrice >= PRESENT_MENU_STANDARD_PRICE) {
            return Menu.CHAMPAGNE;
        }
        return Menu.NONE;
    }

}
