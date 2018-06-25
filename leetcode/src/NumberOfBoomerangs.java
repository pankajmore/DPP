import java.util.HashMap;
import java.util.Map;

/** https://leetcode.com/problems/number-of-boomerangs/ Created by pankaj on 08/11/16. */
public class NumberOfBoomerangs {
  public int numberOfBoomerangs(int[][] points) {
    int cnt = 0;
    Map<Long, Integer> distMap = new HashMap<>();
    for (int[] p : points) {
      distMap.clear();
      for (int[] q : points) {
        int dx = q[0] - p[0];
        int dy = q[1] - p[1];
        long d = dx * dx + dy * dy;
        distMap.put(d, distMap.getOrDefault(d, 0) + 1);
      }
      for (int c : distMap.values()) cnt += c * (c - 1);
    }
    return cnt;
  }
}
