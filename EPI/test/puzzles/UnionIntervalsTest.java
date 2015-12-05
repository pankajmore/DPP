package puzzles;

import org.junit.Test;
import puzzles.UnionIntervals.Interval;
import puzzles.UnionIntervals.Interval.Endpoint;

import java.util.Arrays;
import java.util.List;

import static puzzles.UnionIntervals.unionOfIntervals;

public class UnionIntervalsTest {

    @Test
    public void testUnionOfIntervals() throws Exception {
        List<Interval> intervals = Arrays.asList(
                new Interval(new Endpoint(0, false), new Endpoint(3, false)),
                new Interval(new Endpoint(1, true), new Endpoint(1, true)),
                new Interval(new Endpoint(3, true), new Endpoint(4, false)),
                new Interval(new Endpoint(2, true), new Endpoint(4, true)),
                new Interval(new Endpoint(5, true), new Endpoint(7, false)),
                new Interval(new Endpoint(7, true), new Endpoint(8, false)),
                new Interval(new Endpoint(8, true), new Endpoint(11, false)),
                new Interval(new Endpoint(9, false), new Endpoint(11, true)),
                new Interval(new Endpoint(12, true), new Endpoint(14, false)),
                new Interval(new Endpoint(12, false), new Endpoint(16, true)),
                new Interval(new Endpoint(13, false), new Endpoint(14, false)),
                new Interval(new Endpoint(16, false), new Endpoint(17, false))
        );
        List<Interval> expected = Arrays.asList(
                new Interval(new Endpoint(0, false), new Endpoint(4, true)),
                new Interval(new Endpoint(5, true), new Endpoint(11, true)),
                new Interval(new Endpoint(12, true), new Endpoint(17, false))
        );
        List<Interval> actual = unionOfIntervals(intervals);
        assert actual.equals(expected);
    }
}