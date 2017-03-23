package puzzles;

import org.jetbrains.annotations.NotNull;

import java.util.List;

/** Created by pankaj on 4/7/16. */
public class BuyAndSellStockTwice {
  public static double buyAndSellStockTwice(@NotNull List<Double> prices) {
    int N = prices.size();
    double maxProfit = 0, minSoFar = Double.MAX_VALUE;
    double[] L = new double[N], R = new double[N];
    for (int i = 0; i < N; i++) {
      maxProfit = Math.max(maxProfit, prices.get(i) - minSoFar);
      minSoFar = Math.min(minSoFar, prices.get(i));
      L[i] = maxProfit;
    }
    double maxSoFar = Double.MIN_VALUE;
    maxProfit = 0;
    for (int i = N - 1; i >= 0; i--) {
      maxProfit = Math.max(maxProfit, maxSoFar - prices.get(i));
      maxSoFar = Math.max(maxSoFar, prices.get(i));
      R[i] = maxProfit;
    }
    maxProfit = 0;
    for (int i = 0; i < N; i++) {
      maxProfit = Math.max(maxProfit, L[i] + R[i]);
    }
    return maxProfit;
  }

  public static double buyAndSellStockTwice1(List<Double> prices) {
    int N = prices.size();
    double maxProfit = 0;
    for (int i = 0; i < N; i++) {
      for (int j = i + 1; j < N; j++) {
        maxProfit = Math.max(maxProfit, prices.get(j) - prices.get(i));
      }
    }
    for (int a = 0; a < N; a++) {
      for (int b = a + 1; b < N; b++) {
        double temp = prices.get(b) - prices.get(a);
        for (int c = b + 1; c < N; c++) {
          for (int d = c + 1; d < N; d++) {
            maxProfit = Math.max(maxProfit, prices.get(d) - prices.get(c) + temp);
          }
        }
      }
    }
    return maxProfit;
  }
}
