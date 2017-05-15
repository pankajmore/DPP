import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/** https://leetcode.com/problems/merge-intervals/ Created by pankaj on 15/05/17. */
class MergeIntervals {
  List<Interval> merge(final List<Interval> intervals) {
    intervals.sort(Comparator.comparingInt(x -> x.start));
    List<Interval> merged = new ArrayList<>();
    Interval curr = null;
    for (Interval i : intervals) {
      if (curr == null) {
        curr = i;
      } else if (i.start <= curr.end) {
        curr.end = Math.max(curr.end, i.end);
      } else {
        assert i.start > curr.end;
        merged.add(curr);
        curr = i;
      }
    }
    if (curr != null) {
      merged.add(curr);
    }
    return merged;
  }

  class Interval {
    private int start;
    private int end;

    Interval(final int s, final int e) {
      start = s;
      end = e;
    }
  }
}
