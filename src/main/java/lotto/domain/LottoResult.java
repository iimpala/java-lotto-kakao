package lotto.domain;


import java.util.Map;

public class LottoResult {

    private final Map<Prize, Long> result;

    public LottoResult(Map<Prize, Long> result) {
        this.result = result;
    }

    public Map<Prize, Long> getResult() {
        return Map.copyOf(result);
    }

    public double getProfitRate(LottoPurchaseBudget budget) {
        long profit = result.keySet().stream()
                .mapToLong(prize -> prize.totalReward(result.get(prize)))
                .sum();

        return budget.calculateProfitRate(profit);
    }
}
