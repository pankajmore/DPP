package puzzles;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static puzzles.TiesElection.tiesElection;

/** Created by pankaj on 1/26/16. */
public class TiesElectionTest {

  @Test
  public void testTiesElection() throws Exception {
    List<Integer> votes = Arrays.asList(4, 5, 2, 7);
    assert tiesElection(votes) == 2;

    votes =
        Arrays.asList(
            9, 3, 11, 6, 55, 9, 7, 3, 29, 16, 4, 4, 20, 11, 6, 6, 8, 8, 4, 10, 11, 16, 10, 6, 10, 3,
            5, 6, 4, 14, 5, 29, 15, 3, 18, 7, 7, 20, 4, 9, 3, 11, 38, 6, 3, 13, 12, 5, 10, 3, 3);
    assert 16976480564070L == tiesElection(votes);
  }
}
