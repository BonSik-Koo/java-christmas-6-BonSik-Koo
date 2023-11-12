package christmas.domain;

import christmas.ExceptionMessage;
import java.util.List;
import org.assertj.core.api.Assertions;
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
        Assertions.assertThatThrownBy(() -> new OrderMenus(orderMenus))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.EXCEED_ORDER_MENU_AMOUNT.getMessage());
    }

    private OrderMenu createOrderMenu(Menu menu, int amount) {
        return new OrderMenu(menu, amount);
    }

}