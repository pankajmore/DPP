import java.util.Arrays;
import java.util.Comparator;

/**
 * https://leetcode.com/contest/11/problems/non-overlapping-intervals/
 * Created by pankaj on 10/30/16.
 */
public class NonOverlappingIntervals {
    public int eraseOverlapIntervals(Interval[] intervals) {
        if (intervals.length == 0) return 0;
        Arrays.sort(intervals, Comparator.comparing((Interval i) -> i.end).thenComparing((i) -> i.start));
        Interval prev = intervals[0];
        int cnt = 0;
        for (int i = 1; i < intervals.length; i++) {
            Interval curr = intervals[i];
            if (prev.end <= curr.start) {
                prev = curr;
            } else {
                cnt++;
            }
        }
        return cnt;
    }

    private class Interval {
        int start, end;
    }
}
