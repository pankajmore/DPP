import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/** https://leetcode.com/problems/rabbits-in-forest/description/ */
public class RabbitsInForest {
  public int numRabbits(int[] answers) {
    Map<Integer, Integer> cnt = new HashMap<>();
    Arrays.stream(answers).forEach(ans -> cnt.put(ans, cnt.getOrDefault(ans, 0) + 1));
    return cnt.keySet()
        .stream()
        .mapToInt(k -> Math.floorMod(-cnt.get(k), k + 1) + cnt.get(k))
        .sum();
  }
}
