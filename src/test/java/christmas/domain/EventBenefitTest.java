package christmas.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class EventBenefitTest {

    @DisplayName("총 할인 혜택 금액을 계산한다.")
    @Test
    void calculateTotalDiscountPrice() {
        //given
        final int predictionTotalPrice = 1900 + 4046 + 1000;
        Date date = new Date(10); // 크리스마스, 평일, 스페셜 할인

        List<OrderMenu> menus = List.of(
                createOrderMenu(Menu.ICE_CREAM, 1),
                createOrderMenu(Menu.T_BONE_STEAK, 2),
                createOrderMenu(Menu.CHOCOLATE_CAKE, 1)
        );
        OrderMenus orderMenus = new OrderMenus(menus);

        EventBenefit eventBenefit = new EventBenefit(date, orderMenus);

        //when
        int totalDiscountPrice = eventBenefit.getTotalDiscountPrice();

        //then
        assertThat(totalDiscountPrice).isEqualTo(predictionTotalPrice);
    }

    private OrderMenu createOrderMenu(Menu menu, int amount) {
        return new OrderMenu(menu, amount);
    }

}