package christmas.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class EventDiscountTypeTest {

    @DisplayName("크리스마스 이벤트 할인 정책에 따라 할인 금액을 계산한다.")
    @Test
    void calculateDiscountPriceByChristmasDiscountType() {
        //given
        final EventDiscountType type = EventDiscountType.CHRISTMAS;
        final int diffDay = 3;
        final int predictionResult = 1000 + (100 * diffDay);

        //when
        int disCountPrice = type.calculate(diffDay);

        //then
        assertThat(disCountPrice).isEqualTo(predictionResult);
    }

    @DisplayName("평일 이벤트 할인 정책에 따라 할인 금액을 계산한다.")
    @Test
    void calculateDiscountPriceByWeekDayDiscountType() {
        //given
        final EventDiscountType type = EventDiscountType.WEEKDAY;
        final int dessertMenuCount = 3;
        final int predictionResult = (2023 * dessertMenuCount);

        //when
        int disCountPrice = type.calculate(dessertMenuCount);

        //then
        assertThat(disCountPrice).isEqualTo(predictionResult);
    }

    @DisplayName("주말 이벤트 할인 정책에 따라 할인 금액을 계산한다.")
    @Test
    void calculateDiscountPriceByWeekEndDiscountType() {
        //given
        final EventDiscountType type = EventDiscountType.WEEKEND;
        final int MainMenuCount = 3;
        final int predictionResult = (2023 * MainMenuCount);

        //when
        int disCountPrice = type.calculate(MainMenuCount);

        //then
        assertThat(disCountPrice).isEqualTo(predictionResult);
    }

    @DisplayName("특별 이벤트 할인 정책에 따라 할인 금액을 계산한다.")
    @Test
    void calculateDiscountPriceBySpecialDiscountType() {
        //given
        final EventDiscountType type = EventDiscountType.SPECIAL;

        //when
        int disCountPrice = type.calculate(0);

        //then
        assertThat(disCountPrice).isEqualTo(1000);
    }

}