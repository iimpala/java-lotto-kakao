package lotto.domain;

import java.util.Set;

public class Numbers {

    protected final Set<Number> numbers;

    public Numbers(Set<Number> numbers) {
        this.numbers = numbers;
    }

    protected int compare (Numbers otherNumbers) {
        return (int)numbers.stream()
            .filter(otherNumbers::contains)
            .count();
    }

    protected boolean contains(Number number) {
        return numbers.contains(number);
    }
}
