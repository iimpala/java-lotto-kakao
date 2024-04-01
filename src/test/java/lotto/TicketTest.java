package lotto;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class TicketTest {
    @ParameterizedTest
    @ValueSource(strings = {"1,2,3,4,5,6"})
    public void 로또_번호는_중복되지_않는_6개의_수로_이루어져_있다(String numbers) {
        List<Ball> ballList = parseNumbers(numbers);
        Ticket ticket = new Ticket(ballList);
        Assertions.assertThat(ticket).isInstanceOf(Ticket.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1,2,3,4,6,6"})
    public void 로또_번호가_중복되는_경우_예외를_던진다(String numbers) {
        List<Ball> ballList = parseNumbers(numbers);
        Assertions.assertThatThrownBy(() -> new Ticket(ballList)).isInstanceOf(RuntimeException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1,2,3,4,5", "1,2,3,4,5,6,7"})
    public void 로또_번호가_6개가_아닌_경우_예외를_던진다(String numbers) {
        List<Ball> ballList = parseNumbers(numbers);
        Assertions.assertThatThrownBy(() -> new Ticket(ballList)).isInstanceOf(RuntimeException.class);
    }

    private static List<Ball> parseNumbers(String numbers) {
        List<Ball> ballList = Arrays.stream(numbers.split(","))
            .map(Integer::parseInt)
            .map(Ball::new)
            .collect(Collectors.toList());
        return ballList;
    }

}
