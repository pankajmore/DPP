package puzzles;

import java.util.List;

/**
 * Created by pankaj on 4/8/16.
 */
public class MaxDifferenceKPairs {
    /**
     * Time : O(k*N^2)
     * Space: O(N)
     *
     * @param prices list of stock prices for N days
     * @param k      maximum number of transactions allowed
     * @return the maximum profit
     */
    public static double maxKPairsProfits(List<Double> prices, int k) {
        int N = prices.size();
        k = Math.min(k, N);
        double dp[][] = new double[2][N];
        for (int j = 1; j <= k; j++) {
            for (int i = 1; i < N; i++) {
                dp[j % 2][i] = dp[j % 2][i - 1];
                for (int l = i - 1; l >= 0; l--) {
                    dp[j % 2][i] = Math.max(dp[j % 2][i], prices.get(i) - prices.get(l) + (l == 0 ? 0 : dp[(j + 1) % 2][l - 1]));
                }
            }
        }
        return dp[k % 2][N - 1];
    }

    public static double maxKPairsProfits1(List<Double> prices, int k) {
        if (prices.isEmpty() || k == 0) return 0;
        double maxProfit = 0;
        for (int i = 0; i < prices.size(); i++) {
            for (int j = i + 1; j < prices.size(); j++) {
                if (prices.get(j) < prices.get(i)) continue;
                maxProfit = Math.max(maxProfit, prices.get(j) - prices.get(i)
                        + maxKPairsProfits1(prices.subList(j + 1, prices.size()), k - 1));
            }
        }
        return maxProfit;
    }
}
