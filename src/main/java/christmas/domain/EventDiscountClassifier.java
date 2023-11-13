package christmas.domain;

import java.util.ArrayList;
import java.util.List;

public class EventDiscountClassifier {
    private final static int MIN_DISCOUNT_MENU_COUNT = 1;

    public static List<EventDiscount> generateEventBenefits(Date date, OrderMenus orderMenus) {
        List<EventDiscount> benefits = new ArrayList<>();

        List<EventDiscountType> eventDiscountTypes = EventCalendar.findEventDiscountTypes(date.getDay());
        for (EventDiscountType type : eventDiscountTypes) {
            addChristmasBenefit(benefits, type, date);
            addWeekDayBenefit(benefits, type, orderMenus);
            addWeekEndBenefit(benefits, type, orderMenus);
            addSpecialBenefit(benefits, type);
        }
        return benefits;
    }

    private static void addChristmasBenefit(List<EventDiscount> benefits, EventDiscountType type, Date date) {
        if (type.equals(EventDiscountType.CHRISTMAS)) {
            int diffChristmasStartDate = date.getDiffChristmasStartDate();
            EventDiscount benefit = new EventDiscount(type, diffChristmasStartDate);
            benefits.add(benefit);
        }
    }

    private static void addWeekDayBenefit(List<EventDiscount> benefits, EventDiscountType type, OrderMenus orderMenus) {
        if (type.equals(EventDiscountType.WEEKDAY)) {
            int dessertMenuCount = orderMenus.getDessertMenuCount();
            if (dessertMenuCount >= MIN_DISCOUNT_MENU_COUNT) {
                EventDiscount benefit = new EventDiscount(type, dessertMenuCount);
                benefits.add(benefit);
            }
        }
    }

    private static void addWeekEndBenefit(List<EventDiscount> benefits, EventDiscountType type, OrderMenus orderMenus) {
        if (type.equals(EventDiscountType.WEEKEND)) {
            int mainMenuCount = orderMenus.getMainMenuCount();
            if (mainMenuCount >= MIN_DISCOUNT_MENU_COUNT) {
                EventDiscount benefit = new EventDiscount(type, mainMenuCount);
                benefits.add(benefit);
            }
        }
    }

    private static void addSpecialBenefit(List<EventDiscount> benefits, EventDiscountType type) {
        if (type.equals(EventDiscountType.SPECIAL)) {
            EventDiscount benefit = new EventDiscount(type, 0);
            benefits.add(benefit);
        }
    }

}
