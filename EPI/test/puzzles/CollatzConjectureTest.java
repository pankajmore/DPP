package puzzles;

import org.junit.Test;

import static puzzles.CollatzConjecture.testCollatzConjecture;

/** Created by pankaj on 3/22/16. */
public class CollatzConjectureTest {

  @Test
  public void testTestCollatzConjecture() throws Exception {
    assert testCollatzConjecture(1 << 20);
  }
}
