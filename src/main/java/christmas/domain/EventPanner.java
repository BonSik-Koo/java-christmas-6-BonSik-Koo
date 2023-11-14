package christmas.domain;

import christmas.dto.MenuInfo;
import java.util.List;

public class EventPanner {
    private final Date date;
    private final OrderMenus orderMenus;
    private final EventBenefit eventBenefit;

    public EventPanner(Date date, List<MenuInfo> menuInfos) {
        this.date = date;
        this.orderMenus = new OrderMenus(menuInfos);
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

    public EventBenefit getEventBenefit() {
        return eventBenefit;
    }

    public OrderMenus getOrderMenus() {
        return orderMenus;
    }

}

