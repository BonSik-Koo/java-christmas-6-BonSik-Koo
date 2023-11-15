package christmas.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import christmas.dto.MenuInfo;
import christmas.view.ValidateConstant;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class OrderMenusTest {

    @DisplayName("메뉴를 20개를 초과하여 주문할 경우 예외가 발생한다.")
    @Test
    void createOrderByExceedMaxMenuAmount() {
        //given
        List<MenuInfo> orderMenus = List.of(
                createMenuInfo(Menu.CHAMPAGNE, 15),
                createMenuInfo(Menu.TABAS, 10)
        );

        //when & then
        assertThatThrownBy(() -> new OrderMenus(orderMenus))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ValidateConstant.EXCEED_ORDER_MENU_AMOUNT);
    }

    @DisplayName("주문 시 중복 메뉴가 포함되어 예외가 발생한다.")
    @Test
    void createOrderByDuplicationMenu() {
        //given
        List<MenuInfo> orderMenus = List.of(
                createMenuInfo(Menu.CHAMPAGNE, 5),
                createMenuInfo(Menu.CHAMPAGNE, 5)
        );

        //when & then
        assertThatThrownBy(() -> new OrderMenus(orderMenus))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ValidateConstant.INVALID_ORDER);
    }

    @DisplayName("음료 메뉴만 주문할 경우 예외가 발생한다.")
    @Test
    void createOrderByOnlyDrinkMenu() {
        //given
        List<MenuInfo> orderMenus = List.of(
                createMenuInfo(Menu.CHAMPAGNE, 5),
                createMenuInfo(Menu.ZERO_COLA, 4)
        );

        //when & then
        assertThatThrownBy(() -> new OrderMenus(orderMenus))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ValidateConstant.INVALID_ORDER_MENU);
    }

    @DisplayName("주문한 메뉴의 총 가격을 계산한다.")
    @Test
    void calculateTotalPrice() {
        //given
        final Menu champagne = Menu.CHAMPAGNE;
        final int champagneAmount = 3;
        final Menu iceCream = Menu.ICE_CREAM;
        final int iceCreamAmount = 2;
        List<MenuInfo> menus = List.of(
                createMenuInfo(champagne, champagneAmount),
                createMenuInfo(iceCream, iceCreamAmount)
        );
        OrderMenus orderMenus = new OrderMenus(menus);

        final int predictionTotalPrice =
                (champagne.getPrice() * champagneAmount) + (iceCream.getPrice() * iceCreamAmount);

        //when
        int totalPrice = orderMenus.calculateTotalPrice();

        //then
        assertThat(totalPrice).isEqualTo(predictionTotalPrice);
    }

    @DisplayName("주문한 메뉴에서 디저트 메뉴의 개수를 찾는다.")
    @Test
    void findDessertMenuCount() {
        //given
        List<MenuInfo> menus = List.of(
                createMenuInfo(Menu.ICE_CREAM, 1),
                createMenuInfo(Menu.T_BONE_STEAK, 2),
                createMenuInfo(Menu.CHOCOLATE_CAKE, 3)
        );
        OrderMenus orderMenus = new OrderMenus(menus);

        //when
        int dessertMenuCount = orderMenus.getTotalDessertMenuCount();

        //then
        assertThat(dessertMenuCount).isEqualTo(4);
    }

    @DisplayName("주문한 메뉴에서 메인 메뉴의 개수를 찾는다.")
    @Test
    void findMainMenuCount() {
        //given
        List<MenuInfo> menus = List.of(
                createMenuInfo(Menu.ICE_CREAM, 1),
                createMenuInfo(Menu.T_BONE_STEAK, 2),
                createMenuInfo(Menu.ZERO_COLA, 1)
        );
        OrderMenus orderMenus = new OrderMenus(menus);

        //when
        int mainMenuCount = orderMenus.getTotalMainMenuCount();

        //then
        assertThat(mainMenuCount).isEqualTo(2);
    }

    private MenuInfo createMenuInfo(Menu menu, int amount) {
        return new MenuInfo(menu.getName(), amount);
    }

}