package christmas.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class EventPannerTest {

    @DisplayName("할인 후 예상 결제 금액을 계산한다.")
    @Test
    void calculatePaymentPrice() {
        //given
        final int predictionPaymentPrice = (5000 + 30000) - (6069 + 1000);
        Date date = new Date(31); // 평일, 특별 할인

        List<OrderMenu> menus = List.of(
                createOrderMenu(Menu.ICE_CREAM, 1),
                createOrderMenu(Menu.CHOCOLATE_CAKE, 2)
        );
        OrderMenus orderMenus = new OrderMenus(menus);

        EventPanner eventPanner = new EventPanner(date, orderMenus);

        //when
        int paymentPrice = eventPanner.getPaymentPrice();

        //then
        assertThat(paymentPrice).isEqualTo(predictionPaymentPrice);
    }

    private OrderMenu createOrderMenu(Menu menu, int amount) {
        return new OrderMenu(menu, amount);
    }

}