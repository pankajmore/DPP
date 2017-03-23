package puzzles;

import java.util.List;

/** Created by pankaj on 1/26/16. */
public class TiesElection {
  /**
   * Each state can vote only 1 of the 2 candidates Time : O(N*Sum) Space : O(Sum)
   *
   * @param votes the number of votes for a candidate from each state (N such states)
   * @return the number of ways to get a tie
   */
  public static long tiesElection(List<Integer> votes) {
    int sum = votes.stream().reduce(0, (x, y) -> x + y);
    if (sum % 2 == 1) return 0;
    long[] dp = new long[sum + 1];
    dp[0] = 1;
    dp[votes.get(0)] = 1;
    for (int i = 1; i < votes.size(); i++) {
      for (int s = sum; s >= votes.get(i); s--) {
        dp[s] = dp[s] + dp[s - votes.get(i)];
      }
    }
    return dp[sum / 2];
  }
}
