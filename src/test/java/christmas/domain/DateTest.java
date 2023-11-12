package christmas.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import christmas.ExceptionMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class DateTest {

    @DisplayName("날짜가 1~31일에 벗어날 경우 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(ints = {0, 32, -1, 33})
    void createDayOfOutOfRange1Between31(int day) {
        assertThatThrownBy(() -> new Date(day))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.INVALID_DAY.getMessage());
    }

}