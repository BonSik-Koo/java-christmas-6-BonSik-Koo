package christmas.domain;

public class EventPanner {
    private final Date date;
    private final OrderMenus orderMenus;
    private final EventBenefit eventBenefit;

    public EventPanner(Date date, OrderMenus orderMenus) {
        this.date = date;
        this.orderMenus = orderMenus;
        this.eventBenefit = new EventBenefit(date, orderMenus);
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

