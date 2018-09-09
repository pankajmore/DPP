/** https://leetcode.com/problems/longest-uncommon-subsequence-i/ Created by pankaj on 03/04/17. */
class LongestUncommonSubsequenceI {
  int findLUSlength(String a, String b) {
    return a.equals(b) ? -1 : Math.max(a.length(), b.length());
  }
}
