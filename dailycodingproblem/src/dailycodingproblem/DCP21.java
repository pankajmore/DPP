package dailycodingproblem;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;

class DCP21 {
    static int minRooms(List<Interval> intervals) {
        if (intervals == null || intervals.isEmpty()) {
            return 0;
        }
        Collections.sort(intervals);
        Iterator<Interval> it = intervals.iterator();
        Interval hd = it.next();
        int currEnd = hd.end;
        int minRooms = 1, currRooms = 1;
        while (it.hasNext()) {
            Interval interval = it.next();
            if (interval.start < currEnd) {
                currRooms++;
                minRooms = Math.max(minRooms, currRooms);
            } else {
                currEnd = interval.end;
                currRooms = 1;
            }
        }
        return minRooms;
    }

    static class Interval implements Comparable<Interval> {
        int start, end;

        Interval(int s, int e) {
            if (s > e) {
                throw new IllegalArgumentException("Start cannot be greater than end");
            }
            start = s;
            end = e;
        }

        @Override
        public int compareTo(Interval o) {
            if (this.end != o.end) {
                return Integer.compare(this.end, o.end);
            } else {
                return Integer.compare(this.start, o.start);
            }
        }
    }
}
