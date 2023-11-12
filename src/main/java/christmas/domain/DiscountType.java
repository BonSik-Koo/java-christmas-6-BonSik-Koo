package christmas.domain;

import java.util.function.Function;

public enum DiscountType {
    CHRISTMAS("크리스마스 디데이 할인", target -> 1000 + (target * 100)),
    WEEKDAY("평일 할인", target -> target * 2023),
    WEEKEND("주말 할인", target -> target * 2023),
    SPECIAL("특별 할인", target -> 1000);

    private final String name;
    private final Function<Integer, Integer> function;

    DiscountType(String name, Function<Integer, Integer> function) {
        this.name = name;
        this.function = function;
    }

    public int calculate(int target) {
        return function.apply(target);
    }

}
