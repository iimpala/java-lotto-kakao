package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class NumberTest {

    @ParameterizedTest
    @ValueSource(ints = {1,2,3,4,5,6,7,8,9,10,
        11,12,13,14,15,16,17,18,19,20,
        21,22,23,24,25,26,27,28,29,30,
        31,32,33,34,35,36,37,38,39,40,
        41,42,43,44,45})
    public void 공은_1이상_45이하의_정수여야_한다(int value) {
        Number number = Number.getNumberInstance(value);
        Assertions.assertThat(number).isInstanceOf(Number.class);
    }

    @Test
    public void 공은_1미만일_경우_예외를_던진다() {
        Assertions.assertThatThrownBy(() -> Number.getNumberInstance(0)).isInstanceOf(RuntimeException.class);
    }

    @Test
    public void 공은_45초과일_경우_예외를_던진다() {
        Assertions.assertThatThrownBy(() -> Number.getNumberInstance(46)).isInstanceOf(RuntimeException.class);
    }
}
