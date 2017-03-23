package puzzles;

/** Created by Pankaj on 8/25/15. */
public class LongestPalindromicSubsequence {
  /**
   * Time : O(n^2) Space : O(n)
   *
   * @param s string of length n
   * @return minimum number of chars to be deleted from s to make the resulting string a palindrome
   */
  public static int minDeletes(String s) {
    String r = new StringBuilder(s).reverse().toString();
    return s.length() - LongestCommonSubsequence.usingEditDistance(s, r);
  }
}
