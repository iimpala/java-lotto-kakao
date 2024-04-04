package lotto.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import lotto.domain.Budget;
import lotto.domain.LottoMachine;
import lotto.domain.LottoResult;
import lotto.dto.LottoResultDto;
import lotto.domain.Number;
import lotto.dto.TicketDto;
import lotto.domain.TicketNumbers;
import lotto.domain.WinningNumbers;
import lotto.view.LottoView;

public class LottoController {
    private final LottoMachine lottoMachine;
    private final LottoView view;
    private List<Number> numberPool;

    public LottoController() {
        initNumberPool();
        this.lottoMachine = new LottoMachine(numberPool);
        this.view = new LottoView();
    }

    public void start() {
        List<TicketNumbers> tickets = createTickets();
        view.printTickets(tickets.stream()
            .map(this::ticketNumbersToDto)
            .collect(Collectors.toList()));

        LottoResultDto result = lottoResultToDto(getResult());
        view.printLottoResult(result);
    }

    private List<TicketNumbers> createTickets() {
        List<TicketNumbers> tickets = null;
        try {
            int budget = view.getBudget();
            tickets = lottoMachine.generateTickets(new Budget(budget));
            return tickets;
        } catch (RuntimeException e) {
            view.printError(e);
        }
        return createTickets();
    }

    private LottoResult getResult() {
        try {
            List<Number> numbers = view.getNumbers().stream().map(Number::getNumberInstance).collect(Collectors.toList());
            Number bonusNumber = Number.getNumberInstance(view.getBonusNumber());
            LottoResult lottoResult = lottoMachine.getResult(new WinningNumbers(numbers, bonusNumber));
            return lottoResult;
        } catch (RuntimeException e) {
            view.printError(e);
        }
        return getResult();
    }

    private void initNumberPool() {
        this.numberPool = new ArrayList<>();
        for (int i = 1; i <= 45; i++) {
            numberPool.add(Number.getNumberInstance(i));
        }
    }
    public TicketDto ticketNumbersToDto(TicketNumbers ticketNumbers) {
        return new TicketDto(
            ticketNumbers.getNumbers().stream()
            .map(Number::toInteger)
            .collect(Collectors.toList()));
    }

    public LottoResultDto lottoResultToDto(LottoResult lottoResult) {
        return new LottoResultDto(
            lottoResult.getLottoResult(), lottoResult.getResultRate()
        );
    }
}
