package puzzles;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by pankaj on 2/2/16.
 */
public class NumberSteps {
    /**
     * Time : O(n * k)
     * Space : O(n)
     *
     * @param n the number of stairs
     * @param k the number of steps in each move can be in [1, k]
     * @return the number of permutations to reach the top
     */
    public static int numStepsPermutations(int n, int k) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= k && j <= i; j++) {
                dp[i] += dp[i - j];
            }
        }
        return dp[n];
    }

    /**
     * Time : O(k^n)
     * Space : O(k^n)
     *
     * @param n the number of stairs
     * @param k the number of steps in each move can be [1, k]
     * @return the list of all permutations of steps to reach the top
     */
    public static List<List<Integer>> listStepsPermutations(int n, int k) {
        List<List<Integer>> allSteps = new ArrayList<>();
        if (n == 0) {
            allSteps.add(new ArrayList<>());
            return allSteps;
        }
        for (int lastStep = 1; lastStep <= k && lastStep <= n; lastStep++) {
            for (List<Integer> steps : listStepsPermutations(n - lastStep, k)) {
                steps.add(lastStep);
                allSteps.add(steps);
            }
        }
        return allSteps;
    }
}
