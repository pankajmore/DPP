import java.util.Arrays;

/** https://leetcode.com/problems/freedom-trail/ Created by pankaj on 01/04/17. */
public class FreedomTrail {
  public int findRotateSteps(String ring, String key) {
    int N = ring.length(), M = key.length();
    int[][] dp = new int[M + 1][N + 1];
    for (int i = 0; i <= M; i++) Arrays.fill(dp[i], -1);
    return helper(ring, key, 0, 0, dp) + key.length();
  }

  private int helper(String ring, String key, int ringIndex, int keyIndex, int[][] dp) {
    if (keyIndex == key.length()) return 0;
    if (dp[keyIndex][ringIndex] != -1) return dp[keyIndex][ringIndex];
    int cost = Integer.MAX_VALUE;
    for (int i = 0; i < ring.length(); i++) {
      if (ring.charAt(i) == key.charAt(keyIndex)) {
        int dist = dist(i, ringIndex, ring.length());
        cost = Math.min(cost, dist + helper(ring, key, i, keyIndex + 1, dp));
      }
    }
    return dp[keyIndex][ringIndex] = cost;
  }

  private int dist(int x, int y, int N) {
    int min = Math.min(x, y);
    int max = Math.max(x, y);
    return Math.min(max - min, min + N - max);
  }
}
