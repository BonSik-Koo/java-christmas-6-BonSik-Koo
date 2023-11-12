package christmas.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import christmas.ExceptionMessage;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class OrderMenusTest {

    @DisplayName("메뉴를 20개를 초과하여 주문할 경우 예외가 발생한다.")
    @Test
    void createOrderByExceedMaxMenuAmount() {
        //given
        List<OrderMenu> orderMenus = List.of(
                createOrderMenu(Menu.CHAMPAGNE, 15),
                createOrderMenu(Menu.TABAS, 10)
        );

        //when & then
        assertThatThrownBy(() -> new OrderMenus(orderMenus))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.EXCEED_ORDER_MENU_AMOUNT.getMessage());
    }

    @DisplayName("주문 시 중복 메뉴가 포함되어 예외가 발생한다.")
    @Test
    void createOrderByDuplicationMenu() {
        //given
        List<OrderMenu> orderMenus = List.of(
                createOrderMenu(Menu.CHAMPAGNE, 5),
                createOrderMenu(Menu.CHAMPAGNE, 5)
        );

        //when & then
        assertThatThrownBy(() -> new OrderMenus(orderMenus))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.INVALID_ORDER.getMessage());
    }

    @DisplayName("음료 메뉴만 주문할 경우 예외가 발생한다.")
    @Test
    void createOrderByOnlyDrinkMenu() {
        //given
        List<OrderMenu> orderMenus = List.of(
                createOrderMenu(Menu.CHAMPAGNE, 5),
                createOrderMenu(Menu.ZERO_COLA, 4)
        );

        //when & then
        assertThatThrownBy(() -> new OrderMenus(orderMenus))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.INVALID_ORDER_MENU.getMessage());
    }

    private OrderMenu createOrderMenu(Menu menu, int amount) {
        return new OrderMenu(menu, amount);
    }

}