package christmas.domain;

import static christmas.ExceptionMessage.INVALID_ORDER;

public class OrderMenu {
    private final static int MIN_MENU_ORDER_AMOUNT = 1;
    private final Menu menu;
    private final int amount;

    public OrderMenu(final Menu menu, final int amount) {
        validateAmount(amount);

        this.menu = menu;
        this.amount = amount;
    }

    private void validateAmount(int amount) {
        if(amount < MIN_MENU_ORDER_AMOUNT){
            throw new IllegalArgumentException(INVALID_ORDER.getMessage());
        }
    }

}
