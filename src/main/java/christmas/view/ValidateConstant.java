package christmas.view;

public class ValidateConstant {
    public final static String NUMERIC_PATTERN = "^[0-9]+$";
    public final static String MENU_INPUT_PATTERN = "^([가-힣]+-[0-9]+,)*[가-힣]+-[0-9]+$";
    public final static String COMMA_DELIMITER = ",";

    public static final String EXCEPTION = "[ERROR] ";
    public static final String INVALID_DAY = "유효하지 않은 날짜입니다. 다시 입력해 주세요.";
    public static final String INVALID_ORDER = "유효하지 않은 주문입니다. 다시 입력해 주세요.";
    public static final String INVALID_ORDER_MENU = "음료 메뉴만은 주문이 불가능합니다.";
    public static final String EXCEED_ORDER_MENU_AMOUNT = "메뉴는 한번에 20개까지만 주문할 수 있습니다.";
    public static final String NOT_EXIST_CATEGORY = "메뉴에 해당하는 카테고리가 존재하지 않습니다.";

}
