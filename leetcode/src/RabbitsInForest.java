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
    for (int ans : cnt.keySet()) {
      int numPeople = cnt.get(ans);
      if (numPeople <= ans + 1) {
        sum += ans + 1;
      } else {
        sum += Math.ceil(1.0 * numPeople / (ans + 1)) * (ans + 1);
      }
    }
    return sum;
  }
}
