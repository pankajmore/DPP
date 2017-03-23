package puzzles;

import org.junit.Test;

import java.util.Arrays;

import static puzzles.BinarySearchAiEql.searchEntryEqualToItsIndex;

/** Created by pankaj on 3/6/16. */
public class BinarySearchAiEqlTest {

  @Test
  public void testSearchEntryEqualToItsIndex() throws Exception {
    assert searchEntryEqualToItsIndex(Arrays.asList(-2, 0, 2, 3, 6, 7, 9)) == 3;
  }
}
