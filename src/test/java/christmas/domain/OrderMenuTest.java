package christmas.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import christmas.constant.ExceptionMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
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
        assertThatThrownBy(() -> new OrderMenu(menu.getName(), inputAmount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.INVALID_ORDER.getMessage());
    }

    @DisplayName("주문한 메뉴가 디저트 메뉴일 경우 수량을 반환한다.")
    @Test
    void getDessertMenuCount() {
        //given
        final Menu menu = Menu.ICE_CREAM;
        final int amount = 3;
        OrderMenu orderMenu = createOrderMenu(menu, 3);

        //when
        int dessertMenuCount = orderMenu.getDessertMenuCount();

        //then
        assertThat(dessertMenuCount).isEqualTo(3);
    }

    @DisplayName("주문한 메뉴가 메인 메뉴일 경우 수량을 반환한다.")
    @Test
    void getMainMenuCount() {
        //given
        final Menu menu = Menu.T_BONE_STEAK;
        final int amount = 4;
        OrderMenu orderMenu = createOrderMenu(menu, 4);

        //when
        int mainMenuCount = orderMenu.getMainMenuCount();

        //then
        assertThat(mainMenuCount).isEqualTo(4);
    }

    @DisplayName("주문한 메뉴의 가격을 계산한다.")
    @Test
    void calculatePriceByMenuPriceAndAmount() {
        //given
        final Menu menu = Menu.CHAMPAGNE;
        final int amount = 4;
        final int predictionPrice = menu.getPrice() * amount;
        OrderMenu orderMenu = createOrderMenu(menu, amount);

        //when
        int price = orderMenu.calculatePrice();

        //then
        assertThat(price).isEqualTo(predictionPrice);
    }

    private OrderMenu createOrderMenu(Menu menu, int amount) {
        return new OrderMenu(menu.getName(), amount);
    }

}