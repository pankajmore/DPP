import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.com/problems/implement-magic-dictionary/
 * Created by pankaj on 11/09/17.
 */
class MagicDictionary {
  private Set<String> set;

  MagicDictionary() {
    set = new HashSet<>();
  }

  void buildDict(final String[] dict) {
    Collections.addAll(set, dict);
  }

  boolean search(final String word) {
    for (int i = 0; i < word.length(); i++) {
      for (char c = 'a'; c <= 'z'; c++) {
        String s = word.substring(0, i) + c + word.substring(i + 1, word.length());
        if (c != word.charAt(i) && set.contains(s)) {
          return true;
        }
      }
    }
    return false;
  }
}
