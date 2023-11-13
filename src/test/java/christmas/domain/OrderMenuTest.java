package christmas.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import christmas.ExceptionMessage;
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
        assertThatThrownBy(() -> new OrderMenu(menu, inputAmount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.INVALID_ORDER.getMessage());
    }

    @DisplayName("주문한 메뉴가 음료 메뉴인지 확인한다.")
    @Test
    void isDrinkMenu() {
        //given
        OrderMenu orderMenu = createOrderMenu(Menu.RED_WINE, 4);

        //when
        boolean result = orderMenu.isDrinkMenu();

        //then
        assertThat(result).isTrue();
    }

    @DisplayName("주문한 메뉴가 디저트 메뉴인지 확인한다.")
    @Test
    void isDessertMenu() {
        //given
        OrderMenu orderMenu = createOrderMenu(Menu.ICE_CREAM, 1);

        //when
        boolean result = orderMenu.isDessertMenu();

        //then
        assertThat(result).isTrue();
    }

    @DisplayName("주문한 메뉴가 메인 메뉴인지 확인한다.")
    @Test
    void isMainMenu() {
        //given
        OrderMenu orderMenu = createOrderMenu(Menu.T_BONE_STEAK, 4);

        //when
        boolean result = orderMenu.isMainMenu();

        //then
        assertThat(result).isTrue();
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
        return new OrderMenu(menu, amount);
    }

}