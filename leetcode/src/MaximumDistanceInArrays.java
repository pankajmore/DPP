import java.util.List;

/** https://leetcode.com/problems/maximum-distance-in-arrays/ Created by pankaj on 18/06/17. */
class MaximumDistanceInArrays {
  int maxDistance(final List<List<Integer>> arrays) {
    int m = arrays.size();
    int maxDistance;
    int[] down = new int[m];
    down[m - 1] = arrays.get(m - 1).get(arrays.get(m - 1).size() - 1);
    for (int i = m - 2; i >= 0; i--) {
      int n = arrays.get(i).size();
      down[i] = Math.max(down[i + 1], arrays.get(i).get(n - 1));
    }
    maxDistance = down[1] - arrays.get(0).get(0);
    int up = arrays.get(0).get(arrays.get(0).size() - 1);
    for (int i = 1; i < m - 1; i++) {
      maxDistance = Math.max(maxDistance, Math.max(up, down[i + 1]) - arrays.get(i).get(0));
      up = Math.max(up, arrays.get(i).get(arrays.get(i).size() - 1));
    }
    maxDistance = Math.max(maxDistance, up - arrays.get(m - 1).get(0));
    return maxDistance;
  }
}
