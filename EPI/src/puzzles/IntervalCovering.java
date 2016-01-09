package puzzles;


import puzzles.RenderingCalendar.Interval;

import java.util.*;

/**
 * Created by Pankaj on 1/8/16.
 */
public class IntervalCovering {
    public static List<Integer> findMinimumVisits(List<Interval> intervals) {
        SortedSet<Interval> sortedByStartTimes = new TreeSet<>((a, b) -> a.start() != b.start() ?
                Integer.compare(a.start(), b.start()) : Integer.compare(a.end(), b.end()));
        SortedSet<Interval> sortedByEndTimes = new TreeSet<>((a, b) -> a.end() != b.end() ?
                Integer.compare(a.end(), b.end()) : Integer.compare(a.start(), b.start()));
        sortedByStartTimes.addAll(intervals);
        sortedByEndTimes.addAll(intervals);
        List<Integer> visitTimes = new ArrayList<>();
        while (!sortedByStartTimes.isEmpty() && !sortedByEndTimes.isEmpty()) {
            int minEnd = sortedByEndTimes.first().end();
            visitTimes.add(minEnd);
            final Iterator<Interval> iter = sortedByStartTimes.iterator();
            while (iter.hasNext()) {
                Interval i = iter.next();
                if (i.start() > minEnd) break;
                iter.remove();
                sortedByEndTimes.remove(i);
            }
        }
        return visitTimes;
    }

    public static List<Integer> minimumIntervalCover(List<Interval> intervals) {
        Collections.sort(intervals);
        List<Integer> visitTimes = new ArrayList<>();
        int minEnd = Integer.MAX_VALUE;
        for (Interval interval : intervals) {
            if (interval.start() <= minEnd) {
                minEnd = Math.min(minEnd, interval.end());
            } else {
                visitTimes.add(minEnd);
                minEnd = interval.end();
            }
        }
        visitTimes.add(minEnd);
        return visitTimes;
    }
}
