package puzzles;

import org.junit.Test;

import java.util.Arrays;

import static puzzles.NumberSteps.listStepsPermutations;
import static puzzles.NumberSteps.numStepsPermutations;

/** Created by pankaj on 2/2/16. */
public class NumberStepsTest {

  @Test
  public void testNumStepsPermutations() throws Exception {
    assert 1 == numStepsPermutations(0, 0);
    assert 0 == numStepsPermutations(1, 0);
    assert 1 == numStepsPermutations(0, 1);
    assert 1 == numStepsPermutations(4, 1);
    assert 5 == numStepsPermutations(4, 2);
    assert 7 == numStepsPermutations(4, 3);
    assert 8 == numStepsPermutations(4, 4);
  }

  @Test
  public void testListStepsPermutations() throws Exception {
    assert listStepsPermutations(0, 0).get(0).isEmpty();
    assert Arrays.asList(
            Arrays.asList(1, 1, 1, 1),
            Arrays.asList(2, 1, 1),
            Arrays.asList(1, 2, 1),
            Arrays.asList(1, 1, 2),
            Arrays.asList(2, 2))
        .equals(listStepsPermutations(4, 2));
  }
}
