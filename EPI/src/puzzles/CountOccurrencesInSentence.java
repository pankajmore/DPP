package puzzles;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/** Created by Pankaj on 10/19/15. */
public class CountOccurrencesInSentence {
  public static Map<Character, Integer> countOccurrences(String s) {
    Map<Character, Integer> charToCount = new HashMap<Character, Integer>();
    char[] a = s.toCharArray();
    Arrays.sort(a);
    int count = 1;
    for (int i = 1; i < a.length; i++) {
      if (a[i] == a[i - 1]) count++;
      else {
        charToCount.put(a[i - 1], count);
        count = 1;
      }
    }
    charToCount.put(a[a.length - 1], count);
    return charToCount;
  }
}
