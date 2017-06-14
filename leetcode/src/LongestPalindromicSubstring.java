/** https://leetcode.com/problems/longest-palindromic-substring/ Created by pankaj on 14/06/17. */
class LongestPalindromicSubstring {
  String longestPalindrome(final String s) {
    int beg = 0, end = 0, max = 1;
    for (int m = 0; m < s.length(); m++) {
      for (int i = m - 1, j = m + 1;
          i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j);
          i--, j++) {
        if (j - i + 1 > max) {
          max = j - i + 1;
          end = j;
          beg = i;
        }
      }
      for (int i = m, j = m + 1; i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j); i--, j++) {
        if (j - i + 1 > max) {
          max = j - i + 1;
          end = j;
          beg = i;
        }
      }
    }
    return s.substring(beg, end + 1);
  }
}
