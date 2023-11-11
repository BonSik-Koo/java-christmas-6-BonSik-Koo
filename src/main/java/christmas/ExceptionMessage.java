package christmas;

public enum ExceptionMessage {
    INVALID_ORDER("유효하지 않은 주문입니다. 다시 입력해 주세요.");

    private final String message;
    private final String prefix = "[ERROR] ";

    ExceptionMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return prefix + message;
    }

}
