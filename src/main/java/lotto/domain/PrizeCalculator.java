package lotto.domain;


import static lotto.domain.LottoConstants.*;

import java.util.Map;

public class PrizeCalculator {

    public static double calculate(Map<Prize, Integer> result) {
         Long total = result.entrySet().stream()
             .map((entry) -> entry.getKey().getReward() * entry.getValue())
             .reduce(0L, Long::sum);

        int count = result.values().stream().reduce(0, Integer::sum);

        return total / (count * (double)TICKET_PRICE);
    }
}
