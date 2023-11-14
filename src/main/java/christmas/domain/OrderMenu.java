package christmas.domain;

import static christmas.ExceptionMessage.INVALID_ORDER;

public class OrderMenu {
    private final static int MIN_MENU_AMOUNT = 1;
    private final Menu menu;
    private final int amount;

    public OrderMenu(final String menu, final int amount) {
        validateAmount(amount);

        this.menu = Menu.findMenuBy(menu);
        this.amount = amount;
    }

    private void validateAmount(int amount) {
        if (amount < MIN_MENU_AMOUNT) {
            throw new IllegalArgumentException(INVALID_ORDER.getMessage());
        }
    }

    public int getAmount() {
        return amount;
    }

    public Menu getMenu() {
        return menu;
    }

    public String getMenuName() {
        return menu.getName();
    }

    public int getDessertMenuCount() {
        if (Category.isMenuInCategory(menu, Category.DESSERT)) {
            return amount;
        }
        return 0;
    }

    public int getMainMenuCount() {
        if (Category.isMenuInCategory(menu, Category.MAIN)) {
            return amount;
        }
        return 0;
    }

    public int calculatePrice() {
        return menu.getPrice() * amount;
    }

}
