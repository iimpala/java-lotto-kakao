package lotto.domain;

import static lotto.domain.LottoConstants.*;

public class Budget {
    private final int budget;

    public Budget(int budget) {
        validateBudget(budget);
        this.budget = budget;
    }

    private void validateBudget(int budget) {
        if (budget > BUDGET_MAX) {
            throw new RuntimeException("구매 금액은 10만원을 초과할 수 없습니다.");
        }

        if (budget <= 0) {
            throw new RuntimeException("구매 금액은 양의 정수여야 합니다.");
        }

        if (budget % TICKET_PRICE != 0) {
            throw new RuntimeException("구매 금액은 1000의 배수여야 합니다.");
        }
    }

    public int getTicketQuantity() {
        return budget / TICKET_PRICE;
    }
}
