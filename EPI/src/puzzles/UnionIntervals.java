package puzzles;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Pankaj on 12/4/15.
 */
public class UnionIntervals {
    public static List<Interval> unionOfIntervals(List<Interval> intervals) {
        Collections.sort(intervals);
        List<Interval> union = new ArrayList<>();
        Interval mergedInterval = null;
        for (Interval i : intervals) {
            if (mergedInterval == null) mergedInterval = i;
            else {
                if (!intersect(mergedInterval, i)) {
                    union.add(mergedInterval);
                    mergedInterval = i;
                } else mergedInterval = mergeInterval(mergedInterval, i);
            }
        }
        if (mergedInterval != null) union.add(mergedInterval);
        return union;
    }

    private static boolean intersect(Interval a, Interval b) {
        return b.start.val < a.end.val || b.start.val == a.end.val && (b.start.isClosed || a.end.isClosed);
    }

    private static Interval mergeInterval(Interval a, Interval b) {
        return new Interval(a.start, b.end.val > a.end.val ? b.end : b.end.val == a.end.val ? (b.end.isClosed ? b.end : a.end) : a.end);
    }

    public static class Interval implements Comparable<Interval> {
        public final Endpoint start;
        public final Endpoint end;

        public Interval(Endpoint start, Endpoint end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Interval o) {
            return this.start.compareTo(o.start);
        }

        @Override
        public boolean equals(Object o) {
            if (o == null) return false;
            if (!(o instanceof Interval)) return false;
            Interval other = (Interval) o;
            return this.start.equals(other.start) && this.end.equals(other.end);
        }

        public static class Endpoint implements Comparable<Endpoint> {
            public final int val;
            public final boolean isClosed;

            public Endpoint(int val, boolean isClosed) {
                this.val = val;
                this.isClosed = isClosed;
            }

            @Override
            public int compareTo(Endpoint o) {
                if (this.val != o.val) return Integer.compare(this.val, o.val);
                if (this.isClosed && !o.isClosed) return -1;
                if (!this.isClosed && o.isClosed) return 1;
                return 0;
            }

            @Override
            public boolean equals(Object o) {
                if (o == null) return false;
                if (!(o instanceof Endpoint)) return false;
                Endpoint other = (Endpoint) o;
                return this.val == other.val && this.isClosed == other.isClosed;
            }
        }
    }
}
