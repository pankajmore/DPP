import java.util.List;

/**
 * https://leetcode.com/contest/leetcode-weekly-contest-11/problems/convex-polygon/ Created by
 * pankaj on 5/12/16.
 */
class ConvexPolygon {
  boolean isConvex(List<List<Integer>> points) {
    int N = points.size();
    Boolean sign = null;
    if (N < 3) return false;
    for (int i = 0; i < N; i++) {
      int x1 = points.get((i + 2) % N).get(0) - points.get((i + 1) % N).get(0);
      int y1 = points.get((i + 2) % N).get(1) - points.get((i + 1) % N).get(1);
      int x2 = points.get(i).get(0) - points.get((i + 1) % N).get(0);
      int y2 = points.get(i).get(1) - points.get((i + 1) % N).get(1);
      int curr = x1 * y2 - x2 * y1;
      if (curr != 0) {
        if (sign == null) sign = curr > 0;
        else if (sign != curr > 0) return false;
      }
    }
    return true;
  }
}
