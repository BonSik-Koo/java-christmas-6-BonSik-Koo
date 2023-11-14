package christmas.view;

import static christmas.ExceptionMessage.INVALID_DAY;

public class InputValidator {
    private final static String NUMERIC_PATTERN = "^[0-9]+$";

    public static void validateNumeric(String target) {
        if (!target.matches(NUMERIC_PATTERN)) {
            throw new IllegalArgumentException(INVALID_DAY.getMessage());
        }
    }

}

