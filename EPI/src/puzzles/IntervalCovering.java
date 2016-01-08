package puzzles;


import puzzles.RenderingCalendar.Interval;

import java.util.Collections;
import java.util.List;

/**
 * Created by Pankaj on 1/8/16.
 */
public class IntervalCovering {
    public static int minimumIntervalCover(List<Interval> intervals) {
        Collections.sort(intervals);
        int count = 0, minEnd = Integer.MIN_VALUE;
        for (Interval interval : intervals) {
            if (interval.start() <= minEnd) {
                minEnd = Math.min(minEnd, interval.end());
            } else {
                count++;
                minEnd = interval.end();
            }
        }
        return count;
    }
}
