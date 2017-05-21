import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/** https://leetcode.com/problems/valid-square/ Created by pankaj on 21/05/17. */
class ValidSquare {
  boolean validSquare(final int[] p1, final int[] p2, final int[] p3, final int[] p4) {
    List<Integer> ds =
        Arrays.asList(d(p1, p2), d(p1, p3), d(p1, p4), d(p2, p3), d(p2, p4), d(p3, p4));
    Collections.sort(ds);
    return !ds.get(0).equals(0)
        && ds.get(0).equals(ds.get(1))
        && ds.get(1).equals(ds.get(2))
        && ds.get(2).equals(ds.get(3));
  }

  private int d(final int[] p, final int[] q) {
    return (p[1] - q[1]) * (p[1] - q[1]) + (p[0] - q[0]) * (p[0] - q[0]);
  }
}
