package christmas.domain;

import java.util.Arrays;

public enum EventBadge {
    SANTA("산타", 20000),
    TREE("트리", 10000),
    START("별", 5000),
    NONE("없음", 0);

    private final String name;
    private final int standardPrice;

    EventBadge(String name, int standardPrice) {
        this.name = name;
        this.standardPrice = standardPrice;
    }

    public static EventBadge findBadgeBy(int totalBenefitPrice) {
        return Arrays.stream(EventBadge.values())
                .filter(b -> b.standardPrice <= totalBenefitPrice)
                .findFirst()
                .orElse(EventBadge.NONE);
    }

    public String getName(){
        return name;
    }

}
