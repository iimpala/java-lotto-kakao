package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import lotto.dto.LottoResultDto;

public class LottoMachine {

    private final List<TicketNumbers> tickets = new ArrayList<>();

    private final List<Number> numberPool;

    public LottoMachine(List<Number> numberPool) {
        this.numberPool = numberPool;
    }

    public List<TicketNumbers> generateTickets(Budget budget) {
        int ticketQuantity = budget.getTicketQuantity();

        for (int i = 0; i < ticketQuantity; i++) {
            Collections.shuffle(numberPool);
            tickets.add(new TicketNumbers(numberPool.subList(0, 6)));
        }

        return tickets;
    }

    public LottoResult getResult(WinningNumbers winningNumbers) {
        Map<Prize, Integer> result = new HashMap<>();
        for (Prize prize : Prize.values()) {
            result.put(prize, 0);
        }

        for (TicketNumbers ticket : tickets) {
            Prize prize = winningNumbers.checkWinning(ticket);
            result.compute(prize, (key, oldValue) -> oldValue == null ? 0 : oldValue + 1);
        }

        double resultRate = PrizeCalculator.calculate(result);

        return new LottoResult(result, resultRate);
    }
}
