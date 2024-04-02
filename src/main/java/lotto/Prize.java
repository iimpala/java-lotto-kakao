package lotto;

public enum Prize {
    NOTHING(0L),
    FIFTH(5000L),
    FOURTH(50000L),
    THIRD(1500000L),
    SECOND(30000000L),
    FIRST(2000000000L);

    private final Long reward;

    Prize(Long reward) {
        this.reward = reward;
    }

    public Long getReward() {
        return this.reward;
    }
}
