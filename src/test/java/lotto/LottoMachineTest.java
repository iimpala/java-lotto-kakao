package lotto;

import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class LottoMachineTest {

    @Test
    public void 시스템은_구매_금액에_상응하는_개수의_로또_번호를_만들어준다() {
        LottoMachine lottoMachine = new LottoMachine();
        int price = 15000;

        List<TicketDto> generatedTickets = lottoMachine.generateTickets(new Budget(price));
        Assertions.assertThat(generatedTickets.size()).isEqualTo(15);
    }
}
