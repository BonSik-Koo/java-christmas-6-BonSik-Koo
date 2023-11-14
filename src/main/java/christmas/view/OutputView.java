package christmas.view;

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
    private final static String CRLF = "\n";
    private final static String SPACE = " ";
    private final static String COUNT = "개";
    private final static String WON = "원";
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

    private String convertMenusToString(OrderMenus orderMenus) {
        List<OrderMenu> menus = orderMenus.getOrderMenus();
        return menus.stream()
                .map(o -> o.getMenuName() + SPACE + o.getAmount() + COUNT)
                .collect(Collectors.joining(CRLF));
    }

}
