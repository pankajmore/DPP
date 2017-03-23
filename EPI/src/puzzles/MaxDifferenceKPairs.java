package puzzles;

import java.util.List;

/** Created by pankaj on 4/8/16. */
public class MaxDifferenceKPairs {
  /**
   * Time : O(k*N^2) Space: O(N)
   *
   * @param prices list of stock prices for N days
   * @param k maximum number of transactions allowed
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
          dp[j % 2][i] =
              Math.max(
                  dp[j % 2][i],
                  prices.get(i) - prices.get(l) + (l == 0 ? 0 : dp[(j + 1) % 2][l - 1]));
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
        maxProfit =
            Math.max(
                maxProfit,
                prices.get(j)
                    - prices.get(i)
                    + maxKPairsProfits1(prices.subList(j + 1, prices.size()), k - 1));
      }
    }
    return maxProfit;
  }

  /**
   * Time : If k < N/2 then O(k*N) else O(N) Space: If k < N/2 then O(k), else O(1)
   *
   * @param prices list of stock prices for N days
   * @param k maximum number of transactions allowed
   * @return the maximum profit
   */
  public static double maxKPairsProfits2(List<Double> prices, int k) {
    int N = prices.size();
    k = Math.min(k, N);
    if (2 * k >= N) {
      double maxProfit = 0;
      for (int i = 1; i < N; i++) maxProfit += Math.max(0, prices.get(i) - prices.get(i - 1));
      return maxProfit;
    }
    double[][] maxB = new double[2][k + 1], maxS = new double[2][k + 1];
    for (int i = 0; i < N; i++) {
      for (int j = 1; j <= k; j++) {
        maxB[i % 2][j] =
            i == 0
                ? -prices.get(i)
                : Math.max(maxB[(i - 1) % 2][j], maxS[(i - 1) % 2][j - 1] - prices.get(i));
        maxS[i % 2][j] =
            i == 0 ? 0 : Math.max(maxS[(i - 1) % 2][j], maxB[(i - 1) % 2][j] + prices.get(i));
      }
    }
    return maxS[(N - 1) % 2][k];
  }
}
