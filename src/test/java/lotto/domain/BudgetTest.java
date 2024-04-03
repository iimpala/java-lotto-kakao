package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class BudgetTest {
    @Test
    public void 구매_금액은_10만원_이하여야_한다() {
        Budget budget = new Budget(99000);
        Assertions.assertThat(budget).isInstanceOf(Budget.class);
    }
    @Test
    public void 구매_금액이_10만원을_초과하면_예외를_던진다() {
        Assertions.assertThatThrownBy(() -> new Budget(101000)).isInstanceOf(RuntimeException.class);
    }

    @Test
    public void 구매_금액이_음수일_경우_예외를_던진다() {
        Assertions.assertThatThrownBy(() -> new Budget(0)).isInstanceOf(RuntimeException.class);
        Assertions.assertThatThrownBy(() -> new Budget(-1000)).isInstanceOf(RuntimeException.class);
    }

    @Test
    public void 구매_금액이_1000의_배수가_아니면_예외를_던진다() {
        Assertions.assertThatThrownBy(() -> new Budget(99999)).isInstanceOf(RuntimeException.class);
    }

    @Test
    public void 구매_가능한_티켓의_수를_반환한다() {
        Budget budget = new Budget(15000);
        int quantity = budget.getTicketQuantity();
        Assertions.assertThat(quantity).isEqualTo(15);
    }

}
