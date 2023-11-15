package christmas.view;

import static christmas.view.ValidateConstant.COMMA_DELIMITER;
import static christmas.view.ValidateConstant.INVALID_DAY;
import static christmas.view.ValidateConstant.INVALID_ORDER;
import static christmas.view.ValidateConstant.MENU_INPUT_PATTERN;
import static christmas.view.ValidateConstant.NUMERIC_PATTERN;

public class InputValidator {
    public static void validateNumeric(String target) {
        if (!target.matches(NUMERIC_PATTERN)) {
            throw new IllegalArgumentException(INVALID_DAY);
        }
    }

    public static void validateMenuPattern(String target) {
        String targetRemovedBlank = target.trim();
        if (targetRemovedBlank.endsWith(COMMA_DELIMITER) || !targetRemovedBlank.matches(MENU_INPUT_PATTERN)) {
            throw new IllegalArgumentException(INVALID_ORDER);
        }
    }

}

