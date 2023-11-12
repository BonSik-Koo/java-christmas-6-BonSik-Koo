package christmas.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class EventSeasonTest {

    @DisplayName("해당 날짜에 해당하는 이벤트 시즌를 모두 찾는다.")
    @Test
    void findEventSeasonByDay() {
        //given
        final int day = 10;

        //when
        List<EventSeason> eventSeasons = EventSeason.findEventSeasonByDay(day);

        //then
        assertThat(eventSeasons).contains(
                EventSeason.CHRISTMAS, EventSeason.WEEKDAY, EventSeason.SPECIAL
        );
    }

}