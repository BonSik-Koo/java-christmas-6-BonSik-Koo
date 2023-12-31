package christmas.view;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

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
                .hasMessage(ValidateConstant.INVALID_DAY);
    }

    @DisplayName("문자열이 메뉴 형식에 맞지 않을 경우 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"타피스-1,", "제로콜라+1", "타파스--1", "타파스-1,제로콜라--1", "a타파스-1", "", "타파스", "타파스-", "타파스-a"})
    void validateMenuPattern(String input) {
        assertThatThrownBy(() -> InputValidator.validateMenuPattern(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ValidateConstant.INVALID_ORDER);
    }

}