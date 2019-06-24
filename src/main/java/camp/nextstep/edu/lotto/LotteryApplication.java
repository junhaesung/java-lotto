package camp.nextstep.edu.lotto;

import camp.nextstep.edu.lotto.domain.Lottery;
import camp.nextstep.edu.lotto.domain.NaturalNumber;
import camp.nextstep.edu.lotto.domain.RewardType;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LotteryApplication {

    private static final NaturalNumber PRICE_OF_LOTTERY = NaturalNumber.from(1000);
    private static final int ZERO = 0;

    public NaturalNumber calculateNumberOfAvailableLotteries(NaturalNumber investment) {
        if (investment == null) {
            throw new IllegalArgumentException("'investment' must not be null");
        }
        return investment.divideBy(PRICE_OF_LOTTERY);
    }

    public List<Lottery> purchase(NaturalNumber numberOfLotteries) {
        final int value = numberOfLotteries.value();
        return IntStream.range(ZERO, value)
                .mapToObj(number -> Lottery.randomizedInstance())
                .collect(Collectors.toList());
    }

    public int countScore(Lottery lottery, Lottery winningLottery) {
        if (lottery == null) {
            throw new IllegalArgumentException("'lottery' must not be null");
        }
        if (winningLottery == null) {
            throw new IllegalArgumentException("'winningLottery' must not be null");
        }
        return lottery.score(winningLottery);
    }

    public long getReward(int score) {
        final RewardType rewardType = RewardType.from(score);
        return rewardType.getReward();
    }

    public double calculateEarningsRate(int investment, long reward) {
        if (investment == ZERO) {
            throw new IllegalArgumentException("'investment' must be greater than " + ZERO);
        }
        if (reward < ZERO) {
            throw new IllegalArgumentException("'reward' must be greater than or equal to " + ZERO);
        }
        return reward / (double) investment;
    }
}
