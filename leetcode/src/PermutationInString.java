import java.util.Arrays;

/** https://leetcode.com/problems/permutation-in-string/ Created by pankaj on 30/04/17. */
class PermutationInString {
  boolean checkInclusion(final String s1, final String s2) {
    if (s1 == null || s1.isEmpty()) {
      return true;
    }
    if (s2 == null || s2.isEmpty()) {
      return false;
    }
    int m = s1.length();
    int n = s2.length();
    if (m > n) {
      return false;
    }
    final int size = 26;
    int[] s1Map = new int[size];
    int[] s2Map = new int[size];
    for (int i = 0; i < m; i++) {
      s1Map[s1.charAt(i) - 'a']++;
      s2Map[s2.charAt(i) - 'a']++;
    }
    for (int i = 0; i < n - m; i++) {
      if (Arrays.equals(s1Map, s2Map)) {
        return true;
      }
      s2Map[s2.charAt(i + m) - 'a']++;
      s2Map[s2.charAt(i) - 'a']--;
    }
    return Arrays.equals(s1Map, s2Map);
  }
}
