package christmas.domain;

import java.util.ArrayList;
import java.util.List;

public class EventBenefit {
    private final static int EVENT_BENEFIT_STANDARD_PRICE = 10000;
    private final List<EventDiscount> eventDiscounts;

    public EventBenefit(Date date, OrderMenus orderMenus) {
        this.eventDiscounts = determineEventDiscount(date, orderMenus);
    }

    private List<EventDiscount> determineEventDiscount(Date date, OrderMenus orderMenus) {
        int totalOrderPrice = orderMenus.calculateTotalPrice();
        if (totalOrderPrice >= EVENT_BENEFIT_STANDARD_PRICE) {
            return EventDiscountClassifier.generateEventBenefits(date, orderMenus);
        }
        return new ArrayList<>();
    }

    public int getTotalDiscountPrice() {
        return eventDiscounts.stream()
                .filter(e -> !e.isPresentDiscountType())
                .mapToInt(EventDiscount::getDiscountPrice)
                .sum();
    }

    public int getTotalBenefitPrice() {
        return eventDiscounts.stream()
                .mapToInt(EventDiscount::getDiscountPrice)
                .sum();
    }

}
