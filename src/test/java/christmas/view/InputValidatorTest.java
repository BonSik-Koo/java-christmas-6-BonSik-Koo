package christmas.view;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import christmas.ExceptionMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class InputValidatorTest {

    @DisplayName("문자열이 숫자로만 이루어지지 않을 경우 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"11x", "c345", "abc", "", "123ㅎ4"})
    void validateNumericByString(String input) {
        assertThatThrownBy(() -> InputValidator.validateNumeric(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.INVALID_DAY.getMessage());
    }

}