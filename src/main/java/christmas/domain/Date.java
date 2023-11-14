package christmas.domain;

import static christmas.ExceptionMessage.INVALID_DAY;

public class Date {
    private final static int START_DAY = 1;
    private final static int END_DAY = 31;
    private final static int CHRISTMAS_START_DAY = 1;
    private final int day;

    public Date(int day) {
        validateDay(day);
        this.day = day;
    }

    public void validateDay(int day) {
        if (START_DAY > day || END_DAY < day) {
            throw new IllegalArgumentException(INVALID_DAY.getMessage());
        }
    }

    public int getDay() {
        return day;
    }

    public int getDiffChristmasStartDate() {
        return day - CHRISTMAS_START_DAY;
    }

}
