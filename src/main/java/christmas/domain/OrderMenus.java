package christmas.domain;

import static christmas.view.ValidateConstant.EXCEED_ORDER_MENU_AMOUNT;
import static christmas.view.ValidateConstant.INVALID_ORDER;
import static christmas.view.ValidateConstant.INVALID_ORDER_MENU;

import christmas.dto.MenuInfo;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class OrderMenus {
    private final static int MAX_ORDER_MENU_AMOUNT = 20;
    private final List<OrderMenu> orderMenus;

    public OrderMenus(List<MenuInfo> menuInfos) {
        validateMenuCount(menuInfos);
        validateDuplicationMenu(menuInfos);
        validateOnlyDrinkMenu(menuInfos);

        this.orderMenus = menuInfos.stream()
                .map(m -> new OrderMenu(m.getName(), m.getAmount()))
                .toList();
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

    private void validateMenuCount(List<MenuInfo> menuInfos) {
        int totalCount = menuInfos.stream()
                .mapToInt(MenuInfo::getAmount)
                .sum();
        if (totalCount > MAX_ORDER_MENU_AMOUNT) {
            throw new IllegalArgumentException(EXCEED_ORDER_MENU_AMOUNT);
        }
    }

    private void validateDuplicationMenu(List<MenuInfo> menuInfos) {
        Set<String> menus = new HashSet<>();
        for (MenuInfo menuInfo : menuInfos) {
            if (!menus.add(menuInfo.getName())) {
                throw new IllegalArgumentException(INVALID_ORDER);
            }
        }
    }

    private void validateOnlyDrinkMenu(List<MenuInfo> menuInfos) {
        int drinkMenuCount = menuInfos.stream()
                .map(m -> Category.findCategoryBy(m.getName()))
                .filter(c -> c.equals(Category.DRINK))
                .toList()
                .size();
        if (drinkMenuCount == menuInfos.size()) {
            throw new IllegalArgumentException(INVALID_ORDER_MENU);
        }
    }

}
