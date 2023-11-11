package christmas.domain;

import static christmas.domain.Menu.*;

import java.util.List;

public enum Category {
    APPETIZER(List.of(MUSHROOM_SOUP, TABAS, CAESAR_SALAD)),
    MAIN(List.of(T_BONE_STEAK, BARBECUE_RIBS, SEAFOOD_PASTA, CHRISTMAS_PASTA)),
    DESSERT(List.of(CHOCOLATE_CAKE, ICE_CREAM)),
    DRINK(List.of(ZERO_COLA, RED_WINE, CHAMPAGNE));

    private final List<Menu> menus;

    Category(List<Menu> menus) {
        this.menus = menus;
    }

}
