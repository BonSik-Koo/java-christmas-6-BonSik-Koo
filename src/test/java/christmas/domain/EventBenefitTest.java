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
        final int predictionTotalPrice = 1000 + 2000;

        List<EventDiscount> menus = List.of(
                createEventDiscount(EventDiscountType.SPECIAL, 0),
                createEventDiscount(EventDiscountType.PRESENT, 0),
                createEventDiscount(EventDiscountType.CHRISTMAS, 10)
        );
        EventBenefit eventBenefit = new EventBenefit(menus);

        //when
        int totalDiscountPrice = eventBenefit.getTotalDiscountPrice();

        //then
        assertThat(totalDiscountPrice).isEqualTo(predictionTotalPrice);
    }

    @DisplayName("총 혜택 금액을 계산한다.")
    @Test
    void calculateTotalBenefitPrice() {
        //given
        final int predictionTotalPrice = 1000 + 25000 + 2000;

        List<EventDiscount> menus = List.of(
                createEventDiscount(EventDiscountType.SPECIAL, 0),
                createEventDiscount(EventDiscountType.PRESENT, 0),
                createEventDiscount(EventDiscountType.CHRISTMAS, 10)
        );
        EventBenefit eventBenefit = new EventBenefit(menus);

        //when
        int totalBenefitPrice = eventBenefit.getTotalBenefitPrice();

        //then
        assertThat(totalBenefitPrice).isEqualTo(predictionTotalPrice);
    }

    @DisplayName("할인 혜택 중 증정 할인 헤택을 가지고 있는지 확인한다.")
    @Test
    void hasPresentPresentDiscount() {
        //given
        List<EventDiscount> menus = List.of(
                createEventDiscount(EventDiscountType.SPECIAL, 0),
                createEventDiscount(EventDiscountType.PRESENT, 0),
                createEventDiscount(EventDiscountType.CHRISTMAS, 10)
        );
        EventBenefit eventBenefit = new EventBenefit(menus);

        //when
        boolean result = eventBenefit.hasPresentPresentDiscount();

        //then
        assertThat(result).isTrue();
    }

    private EventDiscount createEventDiscount(EventDiscountType type, int target) {
        return new EventDiscount(type, target);
    }

}