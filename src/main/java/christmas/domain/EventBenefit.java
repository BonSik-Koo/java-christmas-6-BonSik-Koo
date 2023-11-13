package christmas.domain;

import java.util.ArrayList;
import java.util.List;

public class EventBenefit {
    private final static int EVENT_BENEFIT_STANDARD_PRICE = 10000;
    private final static int PRESENT_MENU_STANDARD_PRICE = 120000;
    private final List<EventDiscount> eventDiscounts;
    private final Menu presentMenu;

    public EventBenefit(Date date, OrderMenus orderMenus) {
        this.eventDiscounts = determineEventDiscount(date, orderMenus);
        this.presentMenu = determinePresentMenu(orderMenus);
    }

    private List<EventDiscount> determineEventDiscount(Date date, OrderMenus orderMenus) {
        int totalOrderPrice = orderMenus.calculateTotalPrice();
        if (totalOrderPrice >= EVENT_BENEFIT_STANDARD_PRICE) {
            return EventDiscountClassifier.generateEventBenefits(date, orderMenus);
        }
        return new ArrayList<>();
    }

    private Menu determinePresentMenu(OrderMenus orderMenus) {
        int totalOrderPrice = orderMenus.calculateTotalPrice();
        if (totalOrderPrice >= PRESENT_MENU_STANDARD_PRICE) {
            return Menu.CHAMPAGNE;
        }
        return Menu.NONE;
    }

    public int getTotalDiscountPrice() {
        return eventDiscounts.stream()
                .mapToInt(EventDiscount::getDiscountPrice)
                .sum();
    }

    public int getTotalBenefitPrice() {
        int totalDiscountPrice = getTotalDiscountPrice();
        return totalDiscountPrice + presentMenu.getPrice();
    }

}
