package christmas.domain;

import java.util.List;

public class EventPanner {
    private final Date date;
    private final OrderMenus orderMenus;
    private final EventBenefit eventBenefit;

    public EventPanner(Date date, OrderMenus orderMenus) {
        this.date = date;
        this.orderMenus = orderMenus;

        List<EventDiscount> eventDiscounts = EventBenefitAssistant.generateEventBenefits(date, orderMenus);
        this.eventBenefit = new EventBenefit(eventDiscounts);
    }

    public int getPaymentPrice() {
        int totalOrderMenuPrice = orderMenus.calculateTotalPrice();
        int totalDiscountPrice = eventBenefit.getTotalDiscountPrice();
        return totalOrderMenuPrice - totalDiscountPrice;
    }

    public String getBadge() {
        int totalBenefitPrice = eventBenefit.getTotalBenefitPrice();
        EventBadge eventBadge = EventBadge.findBadgeBy(totalBenefitPrice);
        return eventBadge.getName();
    }

    public EventBenefit getEventBenefit() {
        return eventBenefit;
    }

    public OrderMenus getOrderMenus() {
        return orderMenus;
    }

}

