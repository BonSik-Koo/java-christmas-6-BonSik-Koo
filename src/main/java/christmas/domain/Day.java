package christmas.domain;

import static christmas.ExceptionMessage.INVALID_DAY;

public class Day {
    private final int startDay = 1;
    private final int endDay = 31;
    private final int day;

    public Day(int day) {
        validateDay(day);
        this.day = day;
    }

    public void validateDay(int day){
        if(startDay > day || endDay < day){
            throw new IllegalArgumentException(INVALID_DAY.getMessage());
        }
    }

}
