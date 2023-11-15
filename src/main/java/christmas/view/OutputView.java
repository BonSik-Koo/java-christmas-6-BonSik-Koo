package christmas.view;

import static christmas.view.ValidateConstant.EXCEPTION;
import static christmas.view.ViewConstant.BENEFIT_INFO_MESSAGE;
import static christmas.view.ViewConstant.COLON;
import static christmas.view.ViewConstant.COUNT;
import static christmas.view.ViewConstant.CRLF;
import static christmas.view.ViewConstant.DECIMAL_FORMAT;
import static christmas.view.ViewConstant.EVENT_BADGE_MESSAGE;
import static christmas.view.ViewConstant.EVENT_BENEFIT_PREVIEW_MESSAGE;
import static christmas.view.ViewConstant.EVENT_START_MESSAGE;
import static christmas.view.ViewConstant.MINUS;
import static christmas.view.ViewConstant.NONE;
import static christmas.view.ViewConstant.ORDER_MENU_MESSAGE;
import static christmas.view.ViewConstant.ORDER_TOTAL_PRICE_MESSAGE;
import static christmas.view.ViewConstant.PAYMENT_PRICE_MESSAGE;
import static christmas.view.ViewConstant.PRESENT_MENU;
import static christmas.view.ViewConstant.PRESENT_MENU_MESSAGE;
import static christmas.view.ViewConstant.SPACE;
import static christmas.view.ViewConstant.TOTAL_BENEFIT_PRICE_MESSAGE;
import static christmas.view.ViewConstant.WON;

import christmas.domain.EventBenefit;
import christmas.domain.EventDiscount;
import christmas.domain.OrderMenu;
import christmas.domain.OrderMenus;
import java.text.DecimalFormat;
import java.util.List;
import java.util.stream.Collectors;

public class OutputView {
    private final DecimalFormat df;

    public OutputView() {
        df = new DecimalFormat(DECIMAL_FORMAT);
    }

    public void printEventStartMessage() {
        System.out.println(EVENT_START_MESSAGE);
    }

    public void printEventBenefitPreview(int day) {
        String result = String.format(EVENT_BENEFIT_PREVIEW_MESSAGE, day);
        System.out.println(result);
    }

    public void printOrderInfo(OrderMenus orderMenus) {
        System.out.println(CRLF + ORDER_MENU_MESSAGE);
        String menuInfo = convertMenusToString(orderMenus);
        System.out.println(menuInfo);

        System.out.println(CRLF + ORDER_TOTAL_PRICE_MESSAGE);
        int totalPrice = orderMenus.calculateTotalPrice();
        System.out.println(df.format(totalPrice) + WON);
    }

    public void printBenefitInfo(EventBenefit eventBenefit) {
        System.out.println(CRLF + PRESENT_MENU_MESSAGE);
        String presentMenuInfo = getPresentMenuMessage(eventBenefit);
        System.out.println(presentMenuInfo);

        System.out.println(CRLF + BENEFIT_INFO_MESSAGE);
        String benefitInfo = getBenefitMessage(eventBenefit);
        System.out.println(benefitInfo);

        System.out.println(CRLF + TOTAL_BENEFIT_PRICE_MESSAGE);
        int totalBenefitPrice = eventBenefit.getTotalBenefitPrice();
        System.out.println(MINUS + df.format(totalBenefitPrice) + WON);
    }

    public void printPaymentPrice(int paymentPrice) {
        System.out.println(CRLF + PAYMENT_PRICE_MESSAGE);
        System.out.println(df.format(paymentPrice) + WON);
    }

    public void printEventBadge(String name) {
        System.out.println(CRLF + EVENT_BADGE_MESSAGE);
        System.out.println(name);
    }

    public void printExceptionMessage(String message) {
        System.out.println(EXCEPTION + message);
    }

    private String convertMenusToString(OrderMenus orderMenus) {
        List<OrderMenu> menus = orderMenus.getOrderMenus();
        return menus.stream()
                .map(o -> o.getMenuName() + SPACE + o.getAmount() + COUNT)
                .collect(Collectors.joining(CRLF));
    }

    private String getBenefitMessage(EventBenefit eventBenefit) {
        List<EventDiscount> eventDiscounts = eventBenefit.getEventDiscounts();

        if (eventDiscounts.isEmpty()) {
            return NONE;
        }
        return eventDiscounts.stream()
                .map(e -> e.getEventDiscountTypeName() + COLON + MINUS + df.format(e.getDiscountPrice()) + WON)
                .collect(Collectors.joining(CRLF));
    }

    private String getPresentMenuMessage(EventBenefit eventBenefit) {
        if (eventBenefit.hasPresentPresentDiscount()) {
            return PRESENT_MENU;
        }
        return NONE;
    }

}
