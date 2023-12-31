package christmas.domain;

import static christmas.domain.Menu.*;

import christmas.view.ValidateConstant;
import java.util.Arrays;
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

    public static Category findCategoryBy(Menu menu) {
        return Arrays.stream(Category.values())
                .filter(c -> c.menus.contains(menu))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(ValidateConstant.NOT_EXIST_CATEGORY));
    }

    public static Category findCategoryBy(String menuName) {
        Menu menu = findMenuBy(menuName);
        return findCategoryBy(menu);
    }

    public static boolean isMenuInCategory(Menu menu, Category category) {
        return Arrays.stream(Category.values())
                .filter(c -> c.menus.contains(menu))
                .anyMatch(c -> c.equals(category));
    }

}
