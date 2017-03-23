package puzzles;

import org.junit.Test;
import puzzles.RenderingCalendar.Interval;

import java.util.Arrays;
import java.util.List;

import static puzzles.IntervalCovering.findMinimumVisits;
import static puzzles.IntervalCovering.minimumIntervalCover;

public class IntervalCoveringTest {

  @Test
  public void testMinimumIntervalCover() throws Exception {
    final List<Integer> visits =
        minimumIntervalCover(
            Arrays.asList(new Interval(0, 5), new Interval(1, 2), new Interval(3, 4)));
    assert visits.size() == 2 && visits.get(0) == 2 && visits.get(1) == 4;

    List<Interval> intervals =
        Arrays.asList(
            new Interval(1, 4),
            new Interval(2, 8),
            new Interval(3, 6),
            new Interval(3, 5),
            new Interval(7, 10),
            new Interval(9, 11));
    List<Integer> ans = minimumIntervalCover(intervals);
    assert ans.size() == 2 && ans.get(0) == 4 && ans.get(1) == 10;

    intervals =
        Arrays.asList(
            new Interval(1, 2),
            new Interval(2, 3),
            new Interval(3, 4),
            new Interval(4, 5),
            new Interval(5, 6),
            new Interval(6, 7));
    ans = minimumIntervalCover(intervals);
    System.out.println(ans);
    assert (ans.size() == 3 && ans.get(0) == 2 && ans.get(1) == 4 && ans.get(2) == 6);
  }

  @Test
  public void testFindMinimumVisits() throws Exception {
    List<Interval> intervals =
        Arrays.asList(
            new Interval(1, 4),
            new Interval(2, 8),
            new Interval(3, 6),
            new Interval(3, 5),
            new Interval(7, 10),
            new Interval(9, 11));
    List<Integer> ans = findMinimumVisits(intervals);
    assert (ans.size() == 2 && ans.get(0) == 4 && ans.get(1) == 10);

    intervals =
        Arrays.asList(
            new Interval(1, 2),
            new Interval(2, 3),
            new Interval(3, 4),
            new Interval(4, 5),
            new Interval(5, 6),
            new Interval(6, 7));
    ans = findMinimumVisits(intervals);
    System.out.println(ans);
    assert (ans.size() == 3 && ans.get(0) == 2 && ans.get(1) == 4 && ans.get(2) == 6);
  }
}
