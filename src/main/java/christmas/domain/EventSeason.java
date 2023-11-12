package christmas.domain;

import java.util.Arrays;
import java.util.List;

public enum EventSeason {
    CHRISTMAS(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25)),
    WEEKDAY(List.of(3, 4, 5, 6, 7, 10, 11, 12, 13, 14, 17, 18, 19, 20, 21, 24, 25, 26, 27, 28, 31)),
    WEEKEND(List.of(1, 2, 8, 9, 15, 16, 22, 23, 29, 30)),
    SPECIAL(List.of(3, 10, 17, 24, 25, 31));
    private final List<Integer> days;

    EventSeason(List<Integer> days) {
        this.days = days;
    }

    public static List<EventSeason> findEventSeasonByDay(int day) {
        return Arrays.stream(EventSeason.values())
                .filter(e -> e.days.contains(day))
                .toList();
    }

}
