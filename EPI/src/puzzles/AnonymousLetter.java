package puzzles;

import java.util.HashMap;
import java.util.Map;

/** Created by Pankaj on 7/24/15. */
public class AnonymousLetter {
  public Map<String, Integer> createMap(String[] L) {
    HashMap<String, Integer> lMap = new HashMap<>();
    for (String s : L) {
      if (!lMap.containsKey(s)) lMap.put(s, 0);
      lMap.put(s, lMap.get(s) + 1);
    }
    return lMap;
  }

  public boolean isConstructible(String[] L, String[] M) {
    Map<String, Integer> lMap = createMap(L);
    Map<String, Integer> mMap = createMap(M);
    for (String s : lMap.keySet()) {
      if (!mMap.containsKey(s)) return false;
      if (mMap.get(s) < lMap.get(s)) return false;
    }
    return true;
  }
}
