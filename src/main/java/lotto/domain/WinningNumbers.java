package lotto.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WinningNumbers extends Numbers {
    private final Number bonusNumber;

    public WinningNumbers(List<Number> regularNumbers, Number bonusNumber) {
        this(new HashSet<>(regularNumbers), bonusNumber);
    }

    public WinningNumbers(Set<Number> regularNumbers, Number bonusNumber) {
        super(regularNumbers);
        this.bonusNumber = bonusNumber;
        validateWinningNumber(regularNumbers, bonusNumber);
    }

    public Prize checkWinning(TicketNumbers ticketNumbers) {
        int matchCount = ticketNumbers.match(this);
        if (matchCount <= 2) {
            return Prize.NOTHING;
        }
        return Prize.of(matchCount, ticketNumbers.contains(bonusNumber));
    }

    private void validateWinningNumber(Set<Number> regularNumbers, Number bonusNumber) {
        if (regularNumbers.size() != 6) {
            throw new RuntimeException("당첨번호는 중복되지 않는 6개의 수로 구성되어야 합니다.");
        }

        if (regularNumbers.contains(bonusNumber)) {
            throw new RuntimeException("보너스볼은 당첨 번호와 중복되지 않아야 합니다.");
        }
    }
}
