package lotto.dto;

import java.util.List;

public class LottoResultDto {
    private final List<String> lottoResult;
    private final double resultRate;

    public LottoResultDto(List<String> lottoResult, double resultRate) {
        this.lottoResult = lottoResult;
        this.resultRate = resultRate;
    }

    public List<String> getLottoResult() {
        return lottoResult;
    }

    public double getResultRate() {
        return resultRate;
    }
}
