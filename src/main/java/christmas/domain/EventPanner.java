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

    public EventBadge getBadge() {
        int totalBenefitPrice = eventBenefit.getTotalBenefitPrice();
        return EventBadge.findBadgeBy(totalBenefitPrice);
    }

}

