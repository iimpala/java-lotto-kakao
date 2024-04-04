package lotto.domain;

import java.util.Map;

public class LottoResult {
    private final Map<Prize, Integer> lottoResult;
    private final double resultRate;

    public LottoResult(Map<Prize, Integer> lottoResult, double resultRate) {
        this.lottoResult = lottoResult;
        this.resultRate = resultRate;
    }

    public Map<Prize, Integer> getLottoResult() {
        return lottoResult;
    }

    public double getResultRate() {
        return resultRate;
    }
}
