package christmas.view;

import static christmas.ExceptionMessage.INVALID_DAY;
import static christmas.ExceptionMessage.INVALID_ORDER;

public class InputValidator {
    private final static String NUMERIC_PATTERN = "^[0-9]+$";
    private final static String MENU_INPUT_PATTERN = "^([가-힣]+-[0-9]+,)*[가-힣]+-[0-9]+$";
    private final static String COMMA_DELIMITER = ",";

    public static void validateNumeric(String target) {
        if (!target.matches(NUMERIC_PATTERN)) {
            throw new IllegalArgumentException(INVALID_DAY.getMessage());
        }
    }

    public static void validateMenuPattern(String target) {
        String targetRemovedBlank = target.trim();
        if (targetRemovedBlank.endsWith(COMMA_DELIMITER) || !targetRemovedBlank.matches(MENU_INPUT_PATTERN)) {
            throw new IllegalArgumentException(INVALID_ORDER.getMessage());
        }
    }

}

