package puzzles;

import java.util.*;

/** Created by Pankaj on 7/23/15. */
public class Anagrams {
  public Collection<Set<String>> partitionIntoAnagrams(Set<String> set) {
    HashMap<String, Set<String>> map = new HashMap<>();
    for (String s : set) {
      String key = sortedString(s);
      if (!map.containsKey(key)) map.put(key, new HashSet<>());
      map.get(key).add(s);
    }
    return map.values();
  }

  private String sortedString(String s) {
    char[] chars = s.toCharArray();
    Arrays.sort(chars);
    return new String(chars);
  }
}
