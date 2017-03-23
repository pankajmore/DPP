package puzzles;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static puzzles.RenderingCalendar.Interval;
import static puzzles.RenderingCalendar.findMaxOverlappingIntervals;

public class RenderingCalendarTest {

  @Test
  public void testFindMaxOverlappingIntervals() throws Exception {
    List<RenderingCalendar.Interval> ls =
        Arrays.asList(
            new Interval(1, 5),
            new Interval(2, 7),
            new Interval(4, 5),
            new Interval(6, 10),
            new Interval(8, 9),
            new Interval(9, 17),
            new Interval(11, 13),
            new Interval(12, 15),
            new Interval(14, 15));
    assert findMaxOverlappingIntervals(ls) == 3;
  }
}
