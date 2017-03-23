package puzzles;

/** Created by pankaj on 1/31/16. */
public class Interleave {
  /**
   * Time : O(m * n) Space : O(min(m, n))
   *
   * @param t target string of size m + n
   * @param s1 string of size m > n
   * @param s2 string of size n
   * @return true if t is a valid interleaving of s1 and s2
   */
  public static boolean isInterleavingString(String t, String s1, String s2) {
    int m = s1.length(), n = s2.length();
    if (t.length() != m + n) return false;
    boolean[] dp = new boolean[n + 1];
    for (int i = 0; i <= m; i++) {
      for (int j = 0; j <= n; j++) {
        dp[j] =
            (i == 0 || (dp[j] && s1.charAt(i - 1) == t.charAt(i + j - 1)))
                || (j == 0 || (dp[j - 1] && s2.charAt(j - 1) == t.charAt(i + j - 1)));
      }
    }
    return dp[n];
  }
}
