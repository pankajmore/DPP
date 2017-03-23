package puzzles;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/** Created by Pankaj on 1/7/16. */
public class LongestContainedRange {
  public static int longestContainedRange(List<Integer> L) {
    Set<Integer> set = new HashSet<>(L);
    int maxRange = 1, currRange;
    for (Integer x : L) {
      if (!set.contains(x)) continue;
      int i = x, j = x;
      set.remove(x);
      while (set.contains(i - 1)) {
        set.remove(i - 1);
        i--;
      }
      while (set.contains(j + 1)) {
        set.remove(j + 1);
        j++;
      }
      currRange = j - i + 1;
      maxRange = Math.max(maxRange, currRange);
    }
    return maxRange;
  }
}
