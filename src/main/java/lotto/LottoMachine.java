package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class LottoMachine {

    private final List<TicketNumbers> tickets = new ArrayList<>();

    private final List<Number> numberPool = new ArrayList<>();

    public LottoMachine() {
        initNumberPool();
    }

    private void initNumberPool() {
        for (int i = 1; i <= 45; i++) {
            numberPool.add(new Number(i));
        }
    }

    public List<TicketDto> generateTickets(Budget budget) {
        int ticketQuantity = budget.getTicketQuantity();

        for (int i = 0; i < ticketQuantity; i++) {
            Collections.shuffle(numberPool);
            tickets.add(new TicketNumbers(numberPool.subList(0, 6)));
        }

        return tickets.stream()
            .map(TicketNumbers::toDto)
            .collect(Collectors.toList());
    }
}
