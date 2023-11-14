package christmas.domain;

import static christmas.ExceptionMessage.INVALID_ORDER;

import java.util.Arrays;

public enum Menu {
    MUSHROOM_SOUP("양송이수프", 6_000),
    TABAS("타바스", 5_500),
    CAESAR_SALAD("시저샐러드", 8_000),

    T_BONE_STEAK("티본스테이크", 55_000),
    BARBECUE_RIBS("바비큐립", 54_000),
    SEAFOOD_PASTA("해산물파스타", 35_000),
    CHRISTMAS_PASTA("크리스마스파스타", 25_000),

    CHOCOLATE_CAKE("초코케이크", 15_000),
    ICE_CREAM("아이스크림", 5_000),

    ZERO_COLA("제로콜라", 3_000),
    RED_WINE("레드와인", 60_000),
    CHAMPAGNE("샴페인", 25_000),

    NONE("", 0);

    private final String name;

    private final int price;

    Menu(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public int getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    public static Menu findMenuBy(final String name) {
        return Arrays.stream(Menu.values())
                .filter(m -> m.isEqualName(name))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(INVALID_ORDER.getMessage()));
    }

    private boolean isEqualName(String name) {
        return this.name.equals(name);
    }

}
