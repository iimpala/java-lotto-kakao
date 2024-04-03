package lotto.domain;

import java.util.HashMap;
import java.util.Map;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;


public class PrizeCalculatorTest {

    @Test
    public void 회차_진행_통계_정보를_받아_수익률을_계산한다() throws Exception {
        // given
        Map<Prize, Integer> result = new HashMap<>();
        result.put(Prize.NOTHING, 1);
        result.put(Prize.FIFTH, 1);
        result.put(Prize.FOURTH, 1);
        result.put(Prize.THIRD, 1);
        result.put(Prize.SECOND, 1);
        result.put(Prize.FIRST, 1);

        // when
        double rate = PrizeCalculator.calculate(result);

        // then
        Assertions.assertThat(rate).isEqualTo(338592.5);
    }
}
