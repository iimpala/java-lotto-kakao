package lotto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Ticket {

    private final Set<Ball> balls;
    public Ticket(Set<Ball> balls) {
        if (balls.size() != 6) {
            throw new RuntimeException("로또 번호는 중복되지 않는 6개의 수로 구성되어야 합니다.");
        }

        this.balls = balls;
    }

    public Ticket(List<Ball> balls) {
        this(new HashSet<>(balls));
    }
}
