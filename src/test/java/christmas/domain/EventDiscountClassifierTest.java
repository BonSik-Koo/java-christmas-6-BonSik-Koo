package christmas.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class EventDiscountClassifierTest {

    @DisplayName("날짜와 주문 메뉴에 받을 수 있는 이벤트 혜택을 선별한다.")
    @Test
    void generateEventBenefitsByDateAndOrderMenus() {
        //given
        Date date = new Date(10); // 크리스마스, 평일, 스페셜 할인

        List<OrderMenu> menus = List.of(
                createOrderMenu(Menu.ICE_CREAM, 1),
                createOrderMenu(Menu.T_BONE_STEAK, 2),
                createOrderMenu(Menu.CHOCOLATE_CAKE, 1)
        );
        OrderMenus orderMenus = new OrderMenus(menus);

        //when
        List<EventDiscount> eventBenefits = EventDiscountClassifier.generateEventBenefits(date, orderMenus);

        //then
        assertThat(eventBenefits).hasSize(3);
    }

    @DisplayName("날짜와 주문 메뉴에 받을 수 있는 이벤트 혜택이 하나도 존재하지 않는다.")
    @Test
    void notExistEventBenefit() {
        //given
        Date date = new Date(30); // 주말 할인

        List<OrderMenu> menus = List.of(
                createOrderMenu(Menu.ICE_CREAM, 1),
                createOrderMenu(Menu.CHOCOLATE_CAKE, 1)
        );
        OrderMenus orderMenus = new OrderMenus(menus);

        //when
        List<EventDiscount> eventBenefits = EventDiscountClassifier.generateEventBenefits(date, orderMenus);

        //then
        assertThat(eventBenefits).isEmpty();
    }

    private OrderMenu createOrderMenu(Menu menu, int amount) {
        return new OrderMenu(menu, amount);
    }

}