import java.util.Arrays;

/** https://leetcode.com/contest/11/problems/find-right-interval/ Created by pankaj on 10/31/16. */
public class FindRightInterval {
  public int[] findRightInterval(Interval[] intervals) {
    Pair[] A = new Pair[intervals.length];
    int[] res = new int[intervals.length];
    for (int i = 0; i < intervals.length; i++) {
      A[i] = new Pair(intervals[i], i);
    }
    Arrays.sort(A);
    for (int i = 0; i < intervals.length; i++) {
      res[i] = search(A, intervals[i].end);
    }
    return res;
  }

  int search(Pair[] A, int end) {
    int res = -1, lo = 0, hi = A.length - 1;
    while (lo <= hi) {
      int mid = (lo + hi) >>> 1;
      int start = A[mid].e.start;
      if (start < end) {
        lo = mid + 1;
      } else {
        res = A[mid].idx;
        hi = mid - 1;
      }
    }
    return res;
  }

  private static class Pair implements Comparable<Pair> {
    Interval e;
    int idx;

    Pair(Interval e, int idx) {
      this.e = e;
      this.idx = idx;
    }

    @Override
    public int compareTo(Pair p) {
      return Integer.compare(this.e.start, p.e.start);
    }
  }

  private class Interval {
    int start, end;
  }
}
