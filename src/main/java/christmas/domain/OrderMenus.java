package christmas.domain;

import static christmas.ExceptionMessage.EXCEED_ORDER_MENU_AMOUNT;
import static christmas.ExceptionMessage.INVALID_ORDER;
import static christmas.ExceptionMessage.INVALID_ORDER_MENU;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class OrderMenus {
    private final static int MAX_ORDER_MENU_AMOUNT = 20;
    private final List<OrderMenu> orderMenus;

    public OrderMenus(final List<OrderMenu> orderMenus) {
        validateMenuCount(orderMenus);
        validateDuplicationMenu(orderMenus);
        validateOnlyDrinkMenu(orderMenus);

        this.orderMenus = orderMenus;
    }

    public int calculateTotalPrice() {
        return orderMenus.stream()
                .mapToInt(OrderMenu::calculatePrice)
                .sum();
    }

    public int getTotalDessertMenuCount() {
        return orderMenus.stream()
                .mapToInt(OrderMenu::getDessertMenuCount)
                .sum();
    }

    public int getTotalMainMenuCount() {
        return orderMenus.stream()
                .mapToInt(OrderMenu::getMainMenuCount)
                .sum();
    }

    public List<OrderMenu> getOrderMenus() {
        return Collections.unmodifiableList(orderMenus);
    }

    private void validateMenuCount(List<OrderMenu> orderMenus) {
        int totalCount = orderMenus.stream()
                .mapToInt(OrderMenu::getAmount)
                .sum();
        if (totalCount > MAX_ORDER_MENU_AMOUNT) {
            throw new IllegalArgumentException(EXCEED_ORDER_MENU_AMOUNT.getMessage());
        }
    }

    private void validateDuplicationMenu(List<OrderMenu> orderMenus) {
        Set<Menu> menus = new HashSet<>();
        for (OrderMenu orderMenu : orderMenus) {
            if (!menus.add(orderMenu.getMenu())) {
                throw new IllegalArgumentException(INVALID_ORDER.getMessage());
            }
        }
    }

    private void validateOnlyDrinkMenu(List<OrderMenu> orderMenus) {
        int drinkMenuCount = orderMenus.stream()
                .filter(OrderMenu::isDrinkMenu)
                .toList()
                .size();
        if (drinkMenuCount == orderMenus.size()) {
            throw new IllegalArgumentException(INVALID_ORDER_MENU.getMessage());
        }
    }

}
