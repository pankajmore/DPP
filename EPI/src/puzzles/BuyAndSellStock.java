package puzzles;

import java.util.List;

/**
 * Created by pankaj on 4/6/16.
 */
public class BuyAndSellStock {
    public static double computeMaxProfit(List<Double> prices) {
        double maxProfit = 0, minSoFar = Double.MAX_VALUE;
        for (Double price : prices) {
            maxProfit = Math.max(maxProfit, price - minSoFar);
            minSoFar = Math.min(minSoFar, price);
        }
        return maxProfit;
    }

    public static double computeMaxProfit1(List<Double> prices) {
        double maxProfit = 0;
        for (int i = 0; i < prices.size(); i++) {
            for (int j = i + 1; j < prices.size(); j++) {
                maxProfit = Math.max(maxProfit, prices.get(j) - prices.get(i));
            }
        }
        return maxProfit;
    }
}
