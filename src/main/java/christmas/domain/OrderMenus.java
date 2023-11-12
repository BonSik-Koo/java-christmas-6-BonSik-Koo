package christmas.domain;

import christmas.ExceptionMessage;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class OrderMenus {
    private final static int MAX_ORDER_MENU_AMOUNT = 20;
    private final List<OrderMenu> orderMenus;

    public OrderMenus(final List<OrderMenu> orderMenus) {
        validateMenuCount(orderMenus);
        validateDuplicationMenu(orderMenus);

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

    private void validateDuplicationMenu(List<OrderMenu> orderMenus) {
        Set<Menu> menus = new HashSet<>();
        for (OrderMenu orderMenu : orderMenus) {
            if (!menus.add(orderMenu.getMenu())) {
                throw new IllegalArgumentException(ExceptionMessage.INVALID_ORDER.getMessage());
            }
        }
    }

}
