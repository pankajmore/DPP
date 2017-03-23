package puzzles;

import java.util.HashMap;
import java.util.Map;

/** Created by Pankaj on 10/18/15. */
public class NearestRepetition {
  public static int findNearestRepetition(String[] paragraph) {
    int nearestRepeatedDistance = Integer.MAX_VALUE;
    Map<String, Integer> wordToLatestIndex = new HashMap<>();
    for (int i = 0; i < paragraph.length; i++) {
      if (wordToLatestIndex.containsKey(paragraph[i]))
        nearestRepeatedDistance =
            Math.min(nearestRepeatedDistance, i - wordToLatestIndex.get(paragraph[i]));
      wordToLatestIndex.put(paragraph[i], i);
    }
    return nearestRepeatedDistance;
  }
}
