package christmas.domain;

import java.util.ArrayList;
import java.util.List;

public class EventBenefitClassifier {
    public static List<EventBenefit> generateEventBenefits(Date date, OrderMenus orderMenus) {
        List<EventBenefit> benefits = new ArrayList<>();

        List<EventDiscountType> eventDiscountTypes = EventCalendar.findEventDiscountTypes(date.getDay());
        for (EventDiscountType type : eventDiscountTypes) {
            addChristmasBenefit(benefits, type, date);
            addWeekDayBenefit(benefits, type, orderMenus);
            addWeekEndBenefit(benefits, type, orderMenus);
            addSpecialBenefit(benefits, type);
        }
        return benefits;
    }

    private static void addChristmasBenefit(List<EventBenefit> benefits, EventDiscountType type, Date date) {
        if (type.equals(EventDiscountType.CHRISTMAS)) {
            int diffChristmasStartDate = date.getDiffChristmasStartDate();
            EventBenefit benefit = new EventBenefit(type, diffChristmasStartDate);
            benefits.add(benefit);
        }
    }

    private static void addWeekDayBenefit(List<EventBenefit> benefits, EventDiscountType type, OrderMenus orderMenus) {
        if (type.equals(EventDiscountType.WEEKDAY)) {
            int dessertMenuCount = orderMenus.getDessertMenuCount();
            EventBenefit benefit = new EventBenefit(type, dessertMenuCount);
            benefits.add(benefit);
        }
    }

    private static void addWeekEndBenefit(List<EventBenefit> benefits, EventDiscountType type, OrderMenus orderMenus) {
        if (type.equals(EventDiscountType.WEEKEND)) {
            int mainMenuCount = orderMenus.getMainMenuCount();
            EventBenefit benefit = new EventBenefit(type, mainMenuCount);
            benefits.add(benefit);
        }
    }

    private static void addSpecialBenefit(List<EventBenefit> benefits, EventDiscountType type) {
        if (type.equals(EventDiscountType.SPECIAL)) {
            EventBenefit benefit = new EventBenefit(type, 0);
            benefits.add(benefit);
        }
    }

}
