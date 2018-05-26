/** https://leetcode.com/problems/longest-palindrome/ Created by pankaj on 10/11/16. */
public class LongestPalindrome {
  public int longestPalindrome(String s) {
    int[] counts = new int[256];
    for (char c : s.toCharArray()) counts[c] += 1;
    int sum = 0;
    boolean odd = false;
    for (int cnt : counts) {
      if (cnt % 2 == 0) {
        sum += cnt;
      } else {
        sum += cnt - 1;
        odd = true;
      }
    }
    return sum + (odd ? 1 : 0);
  }
}
