package christmas.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class EventBenefitClassifierTest {

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
        List<EventBenefit> eventBenefits = EventBenefitClassifier.generateEventBenefits(date, orderMenus);

        //then
        assertThat(eventBenefits).hasSize(3);
    }

    private OrderMenu createOrderMenu(Menu menu, int amount) {
        return new OrderMenu(menu, amount);
    }

}