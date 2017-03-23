package puzzles;

import org.junit.Test;

import static puzzles.RodCutting.maxRodCut;

/** Created by pankaj on 2/26/16. */
public class RodCuttingTest {

  @Test
  public void testMaxRodCut() throws Exception {
    assert maxRodCut(new int[] {1, 5, 8, 9, 10, 17, 17, 20}) == 22;
  }
}
