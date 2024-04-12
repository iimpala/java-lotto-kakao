package lotto.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LottoTicketSeller {

    private static final int TICKET_LOTTO_NUMBER_COUNT = 6;

    public static List<LottoTicket> purchaseAutoLottoTickets(LottoPurchaseBudget budget) {
        int ticketQuantity = budget.getTicketQuantity();

        List<LottoNumber> lottoNumbers = LottoNumber.getValues();
        return Stream.generate(() -> {
                    Collections.shuffle(lottoNumbers);
                    return new LottoTicket(lottoNumbers.subList(0, TICKET_LOTTO_NUMBER_COUNT));
                })
                .limit(ticketQuantity)
                .collect(Collectors.toList());
    }

    public static List<LottoTicket> purchaseManualLottoTickets(List<List<Integer>> manualLottoNumbers, LottoPurchaseBudget budget) {
        List<LottoTicket> manualTickets = manualLottoNumbers.stream()
                .map(LottoTicket::of)
                .collect(Collectors.toList());

        budget.purchaseLotto(manualTickets.size());
        return manualTickets;
    }
}
