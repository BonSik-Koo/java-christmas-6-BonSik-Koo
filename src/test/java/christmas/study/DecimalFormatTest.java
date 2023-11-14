package christmas.study;

import static org.assertj.core.api.Assertions.assertThat;

import java.text.DecimalFormat;
import org.junit.jupiter.api.Test;

public class DecimalFormatTest {

    @Test
    void DecimalFormat_천단위_콤마찍기(){
        //given
        int amount = 10000;
        DecimalFormat df = new DecimalFormat("###,###");

        //when
        String result = df.format(amount);

        //then
        assertThat(result).isEqualTo("10,000");
     }

}
