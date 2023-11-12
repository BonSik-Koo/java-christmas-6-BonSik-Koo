package christmas;

public enum ExceptionMessage {
    INVALID_ORDER("유효하지 않은 주문입니다. 다시 입력해 주세요."),
    EXCEED_ORDER_MENU_AMOUNT("메뉴는 한번에 20개까지만 주문할 수 있습니다.");
    private final String message;
    private final String prefix = "[ERROR] ";

    ExceptionMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return prefix + message;
    }

}
