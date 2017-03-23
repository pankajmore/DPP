package puzzles;

import org.junit.Test;
import puzzles.SearchMaze.Point;

import java.util.Arrays;
import java.util.List;

import static puzzles.FishingTrip.maximumFish;
import static puzzles.FishingTrip.maximumFishPath;

/** Created by pankaj on 1/25/16. */
public class FishingTripTest {
  private List<List<Integer>> lake =
      Arrays.asList(
          Arrays.asList(2, 4, 3),
          Arrays.asList(0, 2, 1),
          Arrays.asList(4, 3, 2),
          Arrays.asList(1, 0, 2));

  @Test
  public void testMaximumFish() throws Exception {
    assert maximumFish(lake) == 15;
  }

  @Test
  public void testMaximumFishPath() throws Exception {
    assert maximumFishPath(lake)
        .equals(
            Arrays.asList(
                new Point(0, 0),
                new Point(0, 1),
                new Point(1, 1),
                new Point(2, 1),
                new Point(2, 2),
                new Point(3, 2)));
  }
}
