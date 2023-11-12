package christmas.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CategoryTest {

    @DisplayName("메뉴가 속한 카테고리를 찾는다.")
    @Test
    void findCategoryByMenu() {
        //given
        final Menu menu = Menu.CHAMPAGNE;

        //when
        Category category = Category.findCategoryBy(menu);

        //then
        assertThat(category).isEqualByComparingTo(Category.DRINK);
    }

}