import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/** https://leetcode.com/problems/longest-word-in-dictionary/description/ */
public class LongestWordInDictionary {
  public String longestWord(String[] words) {
    String longest = null;
    Set<String> set = new HashSet<>();
    Collections.addAll(set, words);
    for (String word : words) {
      if ((longest == null
              || longest.length() < word.length()
              || (longest.length() == word.length() && word.compareTo(longest) < 0))
          && allPrefixes(word, set)) {
        longest = word;
      }
    }
    return longest;
  }

  private boolean allPrefixes(String word, Set<String> set) {
    StringBuilder sb = new StringBuilder();
    for (char c : word.toCharArray()) {
      sb.append(c);
      if (!set.contains(sb.toString())) {
        return false;
      }
    }
    return true;
  }
}
