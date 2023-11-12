package christmas.domain;

import static org.assertj.core.api.Assertions.assertThat;
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

    @DisplayName("현재 날짜가 크리스마스 시즌의 날짜인지 확인한다.")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5, 10, 25})
    void isChristmasSeasonDay(int day) {
        //given
        Date date = new Date(day);

        //when
        boolean result = date.isChristmasSeason();

        //then
        assertThat(result).isTrue();
    }

    @DisplayName("현재 날짜가 평일 시즌의 날짜인지 확인한다.")
    @ParameterizedTest
    @ValueSource(ints = {3, 7, 10, 14, 17, 21})
    void isWeekDaySeasonDay(int day) {
        //given
        Date date = new Date(day);

        //when
        boolean result = date.isWeekDaySeason();

        //then
        assertThat(result).isTrue();
    }

    @DisplayName("현재 날짜가 주말 시즌의 날짜인지 확인한다.")
    @ParameterizedTest
    @ValueSource(ints = {1,2,8,9,29})
    void isWeekEndSeasonDay(int day) {
        //given
        Date date = new Date(day);

        //when
        boolean result = date.isWeekEndSeason();

        //then
        assertThat(result).isTrue();
    }

}