package lotto;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class BallTest {

    @Test
    public void 공은_1이상_45이하의_정수여야_한다() {
        Ball ball = new Ball(1);
        Assertions.assertThat(ball).isInstanceOf(Ball.class);
    }

    @Test
    public void 공은_1미만일_경우_예외를_던진다() {
        Assertions.assertThatThrownBy(() -> new Ball(0)).isInstanceOf(RuntimeException.class);
    }

    @Test
    public void 공은_45초과일_경우_예외를_던진다() {
        Assertions.assertThatThrownBy(() -> new Ball(46)).isInstanceOf(RuntimeException.class);
    }
}
