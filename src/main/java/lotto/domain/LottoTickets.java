package lotto.domain;

import java.util.List;
import java.util.stream.Stream;

public class LottoTickets {

    private final List<LottoTicket> tickets;

    public LottoTickets(List<LottoTicket> tickets) {
        this.tickets = tickets;
    }

    public void addAll(LottoTickets otherTickets) {
        this.tickets.addAll(otherTickets.tickets);
    }

    public Stream<LottoTicket> stream() {
        return List.copyOf(tickets).stream();
    }

    public int size() {
        return tickets.size();
    }
}
