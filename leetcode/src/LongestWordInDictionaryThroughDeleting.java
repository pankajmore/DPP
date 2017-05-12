import java.util.List;

/**
 * https://leetcode.com/problems/longest-word-in-dictionary-through-deleting/ Created by pankaj on
 * 12/05/17.
 */
class LongestWordInDictionaryThroughDeleting {
  String findLongestWord(final String s, final List<String> d) {
    String max = "";
    for (String t : d) {
      if (isSubsequence(t, s)
          && (t.length() > max.length() || (t.length() == max.length() && t.compareTo(max) < 0))) {
        max = t;
      }
    }
    return max;
  }

  private boolean isSubsequence(final String sub, final String sup) {
    int m = sub.length();
    int n = sup.length();
    int i = 0;
    for (int j = 0; i < m && j < n; j++) {
      if (sub.charAt(i) == sup.charAt(j)) {
        i++;
      }
    }
    return i == m;
  }
}
