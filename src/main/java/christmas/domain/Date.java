package christmas.domain;

import static christmas.ExceptionMessage.INVALID_DAY;

public class Date {
    private final int startDay = 1;
    private final int endDay = 31;
    private final int christmasStartDay = 1;
    private final int month = 12;
    private final int day;

    public Date(int day) {
        validateDay(day);
        this.day = day;
    }

    public void validateDay(int day) {
        if (startDay > day || endDay < day) {
            throw new IllegalArgumentException(INVALID_DAY.getMessage());
        }
    }

    public int getDay(){
        return day;
    }

    public int getDiffChristmasStartDate(){
        return day - christmasStartDay;
    }

}
