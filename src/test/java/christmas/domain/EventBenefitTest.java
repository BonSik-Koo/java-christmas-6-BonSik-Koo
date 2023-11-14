package christmas.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class EventBenefitTest {

    @DisplayName("총 할인 금액을 계산한다.")
    @Test
    void calculateTotalDiscountPrice() {
        //given
        final int predictionTotalPrice = 1900 + 6069 + 1000;
        Date date = new Date(10); // 크리스마스, 평일, 스페셜 할인

        List<OrderMenu> menus = List.of(
                createOrderMenu(Menu.ICE_CREAM, 1),
                createOrderMenu(Menu.T_BONE_STEAK, 2),
                createOrderMenu(Menu.CHOCOLATE_CAKE, 2)
        );
        OrderMenus orderMenus = new OrderMenus(menus);

        EventBenefit eventBenefit = new EventBenefit(date, orderMenus);

        //when
        int totalDiscountPrice = eventBenefit.getTotalDiscountPrice();

        //then
        assertThat(totalDiscountPrice).isEqualTo(predictionTotalPrice);
    }

    @DisplayName("총 할인 금액이 존재하지 않는다.")
    @Test
    void zeroTotalDiscountPrice() {
        //given
        Date date = new Date(30); // 주말 할인

        List<OrderMenu> menus = List.of(
                createOrderMenu(Menu.ICE_CREAM, 1),
                createOrderMenu(Menu.CHOCOLATE_CAKE, 1)
        );
        OrderMenus orderMenus = new OrderMenus(menus);

        EventBenefit eventBenefit = new EventBenefit(date, orderMenus);

        //when
        int totalDiscountPrice = eventBenefit.getTotalDiscountPrice();

        //then
        assertThat(totalDiscountPrice).isEqualTo(0);
    }

    @DisplayName("총 혜택 금액을 계산한다.")
    @Test
    void calculateTotalBenefitPrice() {
        //given
        final int predictionTotalPrice = (2023 * 20) + 1000 + 25000;
        Date date = new Date(31); // 평일, 특별 할인

        List<OrderMenu> menus = List.of(
                createOrderMenu(Menu.ICE_CREAM, 10),
                createOrderMenu(Menu.CHOCOLATE_CAKE, 10)
        );
        OrderMenus orderMenus = new OrderMenus(menus);

        EventBenefit eventBenefit = new EventBenefit(date, orderMenus);

        //when
        int totalBenefitPrice = eventBenefit.getTotalBenefitPrice();

        //then
        assertThat(totalBenefitPrice).isEqualTo(predictionTotalPrice);
    }

    @DisplayName("할인 혜택 중 증정 할인 헤택을 가지고 있는지 확인한다.")
    @Test
    void hasPresentPresentDiscount() {
        //given
        Date date = new Date(28);

        List<OrderMenu> menus = List.of(
                createOrderMenu(Menu.T_BONE_STEAK, 10)
        );
        OrderMenus orderMenus = new OrderMenus(menus);

        EventBenefit eventBenefit = new EventBenefit(date, orderMenus);

        //when
        boolean result = eventBenefit.hasPresentPresentDiscount();

        //then
        assertThat(result).isTrue();
    }

    private OrderMenu createOrderMenu(Menu menu, int amount) {
        return new OrderMenu(menu, amount);
    }

}