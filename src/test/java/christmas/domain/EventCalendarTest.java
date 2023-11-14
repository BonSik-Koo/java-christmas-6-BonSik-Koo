package christmas.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class EventCalendarTest {

    @DisplayName("해당 날짜에 해당하는 할인 이벤트 종류를 모두 찾는다.")
    @Test
    void findEventDiscountTypeByDay() {
        //given
        final int day = 10;

        //when
        List<EventDiscountType> eventDiscountTypes = EventCalendar.findEventDiscountTypes(day);

        //then
        assertThat(eventDiscountTypes).containsExactly(
                EventDiscountType.CHRISTMAS,
                EventDiscountType.WEEKDAY,
                EventDiscountType.SPECIAL,
                EventDiscountType.PRESENT
        );
    }

}