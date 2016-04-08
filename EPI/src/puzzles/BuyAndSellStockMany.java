package puzzles;

import org.jetbrains.annotations.NotNull;

import java.util.List;

/**
 * Created by pankaj on 4/8/16.
 */
public class BuyAndSellStockMany {
    public static double computeMaxProfit(@NotNull List<Double> prices) {
        int N = prices.size();
        double maxProfit = 0;
        for (int i = 1; i < N; i++) {
            maxProfit += Math.max(0, prices.get(i) - prices.get(i - 1));
        }
        return maxProfit;
    }
}
