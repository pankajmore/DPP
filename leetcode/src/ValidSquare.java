import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/** https://leetcode.com/problems/valid-square/ Created by pankaj on 21/05/17. */
class ValidSquare {
  boolean validSquare(final int[] p1, final int[] p2, final int[] p3, final int[] p4) {
    Set<Integer> ds =
        new HashSet<>(
            Arrays.asList(d(p1, p2), d(p1, p3), d(p1, p4), d(p2, p3), d(p2, p4), d(p3, p4)));
    return !ds.contains(0) && ds.size() == 2;
  }

  private int d(final int[] p, final int[] q) {
    return (p[1] - q[1]) * (p[1] - q[1]) + (p[0] - q[0]) * (p[0] - q[0]);
  }
}
