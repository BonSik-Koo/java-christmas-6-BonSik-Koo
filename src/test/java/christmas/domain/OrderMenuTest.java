package christmas.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import christmas.ExceptionMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class OrderMenuTest {

    @DisplayName("메뉴 주문 개수가 1개 미만일 경우 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(ints = {0, -1, -2, -10})
    void createOrderMenuByAmountLessThan1(int inputAmount) {
        //given
        final Menu menu = Menu.CHAMPAGNE;

        //when & then
        assertThatThrownBy(() -> new OrderMenu(menu, inputAmount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.INVALID_ORDER.getMessage());
    }

}