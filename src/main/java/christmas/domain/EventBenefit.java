package christmas.domain;

import java.util.Collections;
import java.util.List;

public class EventBenefit {
    private final List<EventDiscount> eventDiscounts;

    public EventBenefit(List<EventDiscount> eventDiscounts) {
        this.eventDiscounts = eventDiscounts;
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

    public boolean hasPresentPresentDiscount() {
        return eventDiscounts.stream()
                .anyMatch(EventDiscount::isPresentDiscountType);
    }

    public List<EventDiscount> getEventDiscounts() {
        return Collections.unmodifiableList(eventDiscounts);
    }

}
