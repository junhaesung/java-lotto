package camp.nextstep.edu.lotto.view;

import camp.nextstep.edu.lotto.domain.Lotteries;
import camp.nextstep.edu.lotto.domain.LotteriesReward;

public interface ResultView {
    void printPurchasedLotteries(Lotteries lotteries, int numberOfCustomizedLotteries, int numberOfRandomizedLotteries);

    void printResults(LotteriesReward lotteriesReward, double earningsRate);
}
