/** https://leetcode.com/problems/is-subsequence/ Created by pankaj on 9/5/16. */
public class IsSubsequence {
  public boolean isSubsequence(String s, String t) {
    if (s.length() > t.length()) return false;
    int j = 0;
    for (int i = 0; j < s.length() && i < t.length(); i++) {
      if (s.charAt(j) == t.charAt(i)) j++;
    }
    return j == s.length();
  }
}
