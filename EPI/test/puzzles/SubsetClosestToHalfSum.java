package puzzles;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/** Created by pankaj on 1/26/16. */
public class SubsetClosestToHalfSum {
  /**
   * Time : O(N * Sum) Space : O(N * Sum)
   *
   * @param set list of N integers sum up to Sum
   * @return the subset whose sum is closest to its complementary subset's sum
   */
  public static List<Integer> subsetClosestToHalfSum(List<Integer> set) {
    int N = set.size(), sum = set.stream().reduce(0, (x, y) -> x + y);
    boolean[][] dp = new boolean[N][sum + 1];
    dp[0][0] = true;
    dp[0][set.get(0)] = true;
    for (int i = 1; i < N; i++) {
      for (int s = 0; s <= sum; s++) {
        dp[i][s] = dp[i - 1][s] || (s >= set.get(i) && dp[i - 1][s - set.get(i)]);
      }
    }
    int closestSum = 0, minDifference = sum;
    for (int s = 0; s <= sum / 2; s++) {
      if (dp[N - 1][s]) {
        assert dp[N - 1][sum - s];
        int currDifference = sum - 2 * s;
        if (minDifference > currDifference) {
          minDifference = currDifference;
          closestSum = s;
        }
      }
    }

    List<Integer> subset = new ArrayList<>();
    int remainingSum = closestSum;
    for (int i = N - 1; i >= 0; i--) {
      assert dp[i][remainingSum];
      if (i == 0 && remainingSum == set.get(0)) {
        subset.add(set.get(0));
        remainingSum -= set.get(0);
      }
      if (remainingSum >= set.get(i) && dp[i - 1][remainingSum - set.get(i)]) {
        subset.add(set.get(i));
        remainingSum -= set.get(i);
      }
    }
    assert remainingSum == 0;
    Collections.reverse(subset);
    return subset;
  }
}
