package puzzles;

import org.junit.Test;

import java.util.Arrays;

import static puzzles.PickingUpCoins.maxRevenue;
import static puzzles.PickingUpCoins.maxRevenue1;

/** Created by pankaj on 2/3/16. */
public class PickingUpCoinsTest {

  @Test
  public void testMaxRevenue() throws Exception {
    assert maxRevenue(Arrays.asList(1, 4, 100, 2)) == 101;
    assert maxRevenue(Arrays.asList(25, 5, 10, 5, 10, 5, 10, 25, 1, 25, 1, 25, 1, 25, 5, 10))
        == 140;
  }

  @Test
  public void testMaxRevenue1() throws Exception {
    assert maxRevenue1(Arrays.asList(1, 4, 100, 2)) == 101;
    assert maxRevenue1(Arrays.asList(25, 5, 10, 5, 10, 5, 10, 25, 1, 25, 1, 25, 1, 25, 5, 10))
        == 140;
  }
}
