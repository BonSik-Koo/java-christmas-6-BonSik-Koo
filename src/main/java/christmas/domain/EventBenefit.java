package christmas.domain;

public class EventBenefit {
    private final EventDiscountType discountType;
    private final int discountPrice;

    public EventBenefit(EventDiscountType discountType, int target) {
        this.discountType = discountType;
        this.discountPrice = discountType.calculate(target);
    }

}
