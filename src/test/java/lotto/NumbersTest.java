package lotto;

import java.util.Set;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class NumbersTest {

    @Test
    public void compare는_중복되는_Number의_개수를_반환한다() {
        // given
        Numbers numbers = new Numbers(Set.of(new Number(1), new Number(2), new Number(3)));
        Numbers otherNumbers = new Numbers(Set.of(new Number(2), new Number(3), new Number(4)));

        // when
        int count = numbers.compare(otherNumbers);

        // then
        Assertions.assertThat(count).isEqualTo(2);
    }

    @Test
    public void contains는_해당Number의_포함여부를_반환한다() {
        // given
        Numbers numbers = new Numbers(Set.of(new Number(1), new Number(2), new Number(3)));
        Number number = new Number(1);

        // when
        boolean isContaining = numbers.contains(number);

        // then
        Assertions.assertThat(isContaining).isTrue();
    }
}
