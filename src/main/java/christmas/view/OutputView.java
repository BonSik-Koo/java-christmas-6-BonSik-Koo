package christmas.view;

import christmas.domain.EventBadge;
import christmas.domain.EventBenefit;
import christmas.domain.EventDiscount;
import christmas.domain.OrderMenu;
import christmas.domain.OrderMenus;
import java.text.DecimalFormat;
import java.util.List;
import java.util.stream.Collectors;

public class OutputView {
    private final static String EVENT_START_MESSAGE = "안녕하세요! 우테코 식당 12월 이벤트 플래너입니다.";
    private final static String EVENT_BENEFIT_PREVIEW_MESSAGE = "12월 26일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!";
    private final static String ORDER_MENU_MESSAGE = "<주문 메뉴>";
    private final static String ORDER_TOTAL_PRICE_MESSAGE = "<할인 전 총주문 금액>";
    private final static String PRESENT_MENU_MESSAGE = "<증정 메뉴>";
    private final static String BENEFIT_INFO_MESSAGE = "<혜택 내역>";
    private final static String TOTAL_BENEFIT_PRICE_MESSAGE = "<총혜택 금액>";
    private final static String PAYMENT_PRICE_MESSAGE = "<할인 후 예상 결제 금액>";
    private final static String EVENT_BADGE_MESSAGE = "<12월 이벤트 배지>";
    private final static String PRESENT_MENU = "삼페인 1개";
    private final static String CRLF = "\n";
    private final static String SPACE = " ";
    private final static String COUNT = "개";
    private final static String WON = "원";
    private final static String MINUS = "-";
    private final static String COLON = ": ";
    private final static String NONE = "없음";
    private final DecimalFormat df;

    public OutputView() {
        df = new DecimalFormat("###,###");
    }

    public void printEventStartMessage() {
        System.out.println(EVENT_START_MESSAGE);
    }

    public void printEventBenefitPreviewMessage() {
        System.out.println(EVENT_BENEFIT_PREVIEW_MESSAGE + CRLF);
    }

    public void printOrderInfo(OrderMenus orderMenus) {
        System.out.println(ORDER_MENU_MESSAGE);
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
