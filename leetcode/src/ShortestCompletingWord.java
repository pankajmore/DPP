import java.util.HashMap;
import java.util.Map;

/** https://leetcode.com/problems/shortest-completing-word/description/ */
class ShortestCompletingWord {
  String shortestCompletingWord(String licensePlate, String[] words) {
    Map<Character, Integer> licenseMap = new HashMap<>();
    for (char c : licensePlate.toCharArray()) {
      if (Character.isLetter(c)) {
        char lo = Character.toLowerCase(c);
        licenseMap.put(lo, licenseMap.getOrDefault(lo, 0) + 1);
      }
    }
    String min = null;
    for (String word : words) {
      Map<Character, Integer> map = new HashMap<>(licenseMap);
      if ((min == null || word.length() < min.length()) && contains(word, map)) {
        min = word;
      }
    }
    return min;
  }

  private boolean contains(String word, Map<Character, Integer> map) {
    for (char c : word.toCharArray()) {
      if (map.containsKey(c)) {
        int cnt = map.get(c) - 1;
        if (cnt == 0) {
          map.remove(c);
        } else {
          map.put(c, cnt);
        }
      }
    }
    return map.isEmpty();
  }
}
