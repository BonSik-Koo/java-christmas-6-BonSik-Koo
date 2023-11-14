package christmas.domain;

public class EventDiscount {
    private final EventDiscountType discountType;
    private final int discountPrice;

    public EventDiscount(EventDiscountType discountType, int target) {
        this.discountType = discountType;
        this.discountPrice = discountType.calculate(target);
    }

    public int getDiscountPrice() {
        return discountPrice;
    }

    public boolean isPresentDiscountType() {
        return discountType.equals(EventDiscountType.PRESENT);
    }

}
