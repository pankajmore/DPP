/**
 * https://leetcode.com/contest/leetcode-weekly-contest-17/problems/teemo-attacking/ Created by
 * pankaj on 29/01/17.
 */
public class TeemoAttacking {
  public int findPosisonedDuration(int[] timeSeries, int duration) {
    int N = timeSeries.length;
    if (N == 0) return 0;
    int total = 0;
    for (int i = 1; i < N; i++) {
      total += Math.min(timeSeries[i] - timeSeries[i - 1], duration);
    }
    total += duration;
    return total;
  }
}
