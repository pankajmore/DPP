package puzzles;

import org.junit.Test;
import puzzles.RenderingCalendar.Interval;

import java.util.Arrays;

import static puzzles.IntervalCovering.minimumIntervalCover;

public class IntervalCoveringTest {

    @Test
    public void testMinimumIntervalCover() throws Exception {
        assert 2 == minimumIntervalCover(Arrays.asList(
                new Interval(0, 5),
                new Interval(1, 2),
                new Interval(3, 4)));
    }
}