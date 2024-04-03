package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class NumberTest {

    @Test
    public void 공은_1이상_45이하의_정수여야_한다() {
        Number number = new Number(1);
        Assertions.assertThat(number).isInstanceOf(Number.class);
    }

    @Test
    public void 공은_1미만일_경우_예외를_던진다() {
        Assertions.assertThatThrownBy(() -> new Number(0)).isInstanceOf(RuntimeException.class);
    }

    @Test
    public void 공은_45초과일_경우_예외를_던진다() {
        Assertions.assertThatThrownBy(() -> new Number(46)).isInstanceOf(RuntimeException.class);
    }
}
