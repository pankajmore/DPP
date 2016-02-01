package puzzles;

import java.util.List;

/**
 * Created by pankaj on 2/1/16.
 */
public class RepublicanMajority {
    /**
     * Time : O(n^2)
     * Space : O(n)
     *
     * @param probabilities a list of n probabilities. p_i is the probability of i_th republican candidate winning
     * @return the probability that the house has a republican majority
     */
    public static double probabilityOfRepublicanMajority(List<Double> probabilities) {
        int n = probabilities.size();
        double[] dp = new double[n + 1];
        dp[0] = 1.0;
        for (int i = 1; i <= n; i++) {
            for (int k = 0; k <= i; k++) {
                dp[k] = dp[k] * (1 - probabilities.get(i - 1)) + (k == 0 ? 1 : dp[k - 1]) * probabilities.get(i - 1);
            }
        }
        int majorityProbability = 0;
        for (int i = n; i > n / 2; i--) majorityProbability += dp[i];
        return majorityProbability;
    }
}
