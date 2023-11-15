package christmas.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import christmas.view.ValidateConstant;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class MenuTest {

    @DisplayName("메뉴 이름을 통해 메뉴판의 메뉴를 찾는다.")
    @Test
    void findMenuByName() {
        //given
        final String name = "초코케이크";

        //when
        Menu menu = Menu.findMenuBy(name);

        //then
        assertThat(menu).isEqualByComparingTo(Menu.CHOCOLATE_CAKE);
    }

    @DisplayName("메뉴 이름에 해당하는 메뉴가 메뉴판에 존재하지 않을 경우 예외가 발생한다.")
    @Test
    void findMenuByNotExistName() {
        //given
        final String menuName = "화이트와인";

        //when & then
        assertThatThrownBy(() -> Menu.findMenuBy(menuName))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ValidateConstant.INVALID_ORDER);
    }

}