import java.util.Arrays;

/**
 * https://leetcode.com/contest/1/problems/first-unique-character-in-a-string/ Created by pankaj on
 * 8/21/16.
 */
public class FirstUniqueCharacterInAString {
  public int firstUniqChar(String s) {
    if (s == null) return -1;
    int[] A = new int[26];
    Arrays.fill(A, -1);
    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      int pos = (int) c - 97;
      if (A[pos] == -1) A[pos] = i;
      else A[pos] = -2;
    }
    int minIdx = Integer.MAX_VALUE;
    for (int i = 0; i < 26; i++) {
      if (A[i] >= 0) minIdx = Math.min(minIdx, A[i]);
    }
    return minIdx == Integer.MAX_VALUE ? -1 : minIdx;
  }
}
