package christmas.domain;

import java.util.stream.Stream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class BadgeTest {

    @DisplayName("총 혜택 금액에 맞는 이벤트 뱃지를 찾느다.")
    @ParameterizedTest
    @MethodSource("generateData")
    void findEventBadgeByTotalBenefitPrice(int totalBenefitPrice, EventBadge result) {
        //given & when
        EventBadge badge = EventBadge.findBadgeBy(totalBenefitPrice);

        //then
        Assertions.assertThat(badge).isEqualByComparingTo(result);
    }

    static Stream<Arguments> generateData() {
        return Stream.of(
                Arguments.of(11000, EventBadge.TREE),
                Arguments.of(19999, EventBadge.TREE),
                Arguments.of(21000, EventBadge.SANTA),
                Arguments.of(20000, EventBadge.SANTA),
                Arguments.of(5000, EventBadge.START),
                Arguments.of(4999, EventBadge.NONE)
        );
    }

}