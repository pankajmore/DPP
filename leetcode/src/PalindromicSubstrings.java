/** https://leetcode.com/problems/palindromic-substrings/ Created by pankaj on 23/07/17. */
class PalindromicSubstrings {
  int countSubstrings(final String s) {
    int cnt = 0;
    int n = s.length();
    for (int m = 0; m < n; m++) {
      for (int i = m, j = m; i >= 0 && j < n && s.charAt(i) == s.charAt(j); i--, j++) {
        cnt++;
      }
      for (int i = m, j = m + 1; i >= 0 && j < n && s.charAt(i) == s.charAt(j); i--, j++) {
        cnt++;
      }
    }
    return cnt;
  }
}
