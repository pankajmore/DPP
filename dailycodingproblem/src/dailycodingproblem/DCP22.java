package dailycodingproblem;

import java.util.*;

/**
 * Given a dictionary of words and a string made up of those words (no spaces), return the original
 * sentence in a list. If there is more than one possible reconstruction, return any of them. If
 * there is no possible reconstruction, then return null.
 */
class DCP22 {
  static List<String> wordBreak(String s, List<String> wordDict) {
    Set<String> set = new HashSet<>(wordDict);
    int len = s.length();
    boolean[] valid = new boolean[len + 1];
    int[] prev = new int[len + 1];
    valid[0] = true;
    prev[0] = -1;
    for (int i = 1; i <= len; i++) {
      for (int j = 0; j < i; j++) {
        if (valid[j] && set.contains(s.substring(j, i))) {
          valid[i] = true;
          prev[i] = j;
          break;
        }
      }
    }
    if (!valid[len]) {
      return null;
    }
    List<String> words = new ArrayList<>();
    for (int i = prev[len], j = len; i != -1; j = i, i = prev[i]) {
      words.add(s.substring(i, j));
    }
    Collections.reverse(words);
    return words;
  }
}
