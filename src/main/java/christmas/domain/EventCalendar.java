package christmas.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum EventCalendar {
    CHRISTMAS(
            EventDiscountType.CHRISTMAS,
            List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25)
    ),
    WEEKDAY(EventDiscountType.WEEKDAY,
            List.of(3, 4, 5, 6, 7, 10, 11, 12, 13, 14, 17, 18, 19, 20, 21, 24, 25, 26, 27, 28, 31)
    ),
    WEEKEND(EventDiscountType.WEEKEND,
            List.of(1, 2, 8, 9, 15, 16, 22, 23, 29, 30)
    ),
    SPECIAL(EventDiscountType.SPECIAL,
            List.of(3, 10, 17, 24, 25, 31)
    ),
    PRESENT(EventDiscountType.SPECIAL,
            List.of());

    private final EventDiscountType discountType;
    private final List<Integer> days;

    EventCalendar(EventDiscountType discountType, List<Integer> days) {
        this.discountType = discountType;
        this.days = days;
    }

    public static List<EventDiscountType> findEventDiscountTypes(int day) {
        List<EventDiscountType> discountTypes = Arrays.stream(EventCalendar.values())
                .filter(e -> e.days.contains(day))
                .map(e -> e.discountType)
                .collect(Collectors.toList());

        discountTypes.add(EventDiscountType.PRESENT); //날짜 상관없이 증정 이벤트 참여는 가능
        return discountTypes;
    }

}
