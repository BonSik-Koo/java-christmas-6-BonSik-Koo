package christmas.domain;

import christmas.ExceptionMessage;
import java.util.List;

public class OrderMenus {
    private final static int MAX_ORDER_MENU_AMOUNT = 20;
    private final List<OrderMenu> orderMenus;

    public OrderMenus(final List<OrderMenu> orderMenus) {
        validateMenuCount(orderMenus);

        this.orderMenus = orderMenus;
    }

    private void validateMenuCount(List<OrderMenu> orderMenus) {
        int totalCount = orderMenus.stream()
                .mapToInt(OrderMenu::getAmount)
                .sum();
        if (totalCount > MAX_ORDER_MENU_AMOUNT) {
            throw new IllegalArgumentException(ExceptionMessage.EXCEED_ORDER_MENU_AMOUNT.getMessage());
        }
    }

}
