import java.util.HashMap;
import java.util.Map;

/** https://leetcode.com/problems/rabbits-in-forest/description/ */
public class RabbitsInForest {
  public int numRabbits(int[] answers) {
    Map<Integer, Integer> cnt = new HashMap<>();
    for (int ans : answers) {
      cnt.put(ans, cnt.getOrDefault(ans, 0) + 1);
    }
    int sum = 0;
    for (int k : cnt.keySet()) {
      sum += Math.floorMod(-cnt.get(k), k + 1) + cnt.get(k);
    }
    return sum;
  }
}
