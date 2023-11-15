package christmas.domain;

import static org.assertj.core.api.Assertions.assertThat;

import christmas.dto.MenuInfo;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class EventBenefitAssistantTest {

    @DisplayName("날짜와 주문 메뉴에 받을 수 있는 이벤트 혜택을 선별한다.")
    @Test
    void generateEventBenefitsByDateAndOrderMenus() {
        //given
        Date date = new Date(10); // 크리스마스, 평일, 스페셜 할인, 증정 이벤트

        List<MenuInfo> menus = List.of(
                createMenuInfo(Menu.ICE_CREAM, 1),
                createMenuInfo(Menu.T_BONE_STEAK, 2),
                createMenuInfo(Menu.CHOCOLATE_CAKE, 1)
        );
        OrderMenus orderMenus = new OrderMenus(menus);

        //when
        List<EventDiscount> eventBenefits = EventBenefitAssistant.generateEventBenefits(date, orderMenus);

        //then
        assertThat(eventBenefits).hasSize(4);
    }

    @DisplayName("날짜와 주문 메뉴에 받을 수 있는 이벤트 혜택이 하나도 존재하지 않는다.")
    @Test
    void notExistEventBenefit() {
        //given
        Date date = new Date(30); // 주말 할인

        List<MenuInfo> menus = List.of(
                createMenuInfo(Menu.ICE_CREAM, 1),
                createMenuInfo(Menu.CHOCOLATE_CAKE, 1)
        );
        OrderMenus orderMenus = new OrderMenus(menus);

        //when
        List<EventDiscount> eventBenefits = EventBenefitAssistant.generateEventBenefits(date, orderMenus);

        //then
        assertThat(eventBenefits).isEmpty();
    }

    private MenuInfo createMenuInfo(Menu menu, int amount) {
        return new MenuInfo(menu.getName(), amount);
    }

}