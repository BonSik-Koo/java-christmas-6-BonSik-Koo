package christmas.constant;

public enum ExceptionMessage {
    INVALID_DAY("유효하지 않은 날짜입니다. 다시 입력해 주세요."),
    INVALID_ORDER("유효하지 않은 주문입니다. 다시 입력해 주세요."),
    INVALID_ORDER_MENU("음료 메뉴만은 주문이 불가능합니다."),
    EXCEED_ORDER_MENU_AMOUNT("메뉴는 한번에 20개까지만 주문할 수 있습니다."),
    NOT_EXIST_CATEGORY("메뉴에 해당하는 카테고리가 존재하지 않습니다.");
    private final String message;
    private final String prefix = "[ERROR] ";

    ExceptionMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return prefix + message;
    }

}
