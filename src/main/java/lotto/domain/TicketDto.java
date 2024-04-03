package lotto.domain;

import java.util.Set;

public class TicketDto {
    Set<Integer> numbers;

    public TicketDto(Set<Integer> numbers) {
        this.numbers = numbers;
    }

    public Set<Integer> getNumbers() {
        return numbers;
    }
}
