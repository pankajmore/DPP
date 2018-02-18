package dailycodingproblem;

import org.junit.jupiter.api.Test;

import static dailycodingproblem.DCP42.subsetSum;
import static java.util.Arrays.asList;
import static java.util.Collections.emptyList;
import static java.util.Collections.singletonList;
import static org.junit.jupiter.api.Assertions.assertEquals;

class DCP42Test {

  @Test
  void subsetSumTest() {
    assertEquals(emptyList(), subsetSum(emptyList(), 0));
    assertEquals(null, subsetSum(emptyList(), 1));
    assertEquals(emptyList(), subsetSum(singletonList(1), 0));
    assertEquals(singletonList(1), subsetSum(singletonList(1), 1));
    assertEquals(singletonList(1), subsetSum(asList(1, 2), 1));
    assertEquals(singletonList(2), subsetSum(asList(1, 2), 2));
    assertEquals(asList(1, 2), subsetSum(asList(1, 2), 3));
    assertEquals(null, subsetSum(asList(1, 2), 4));
    assertEquals(asList(12, 1, 9, 2), subsetSum(asList(12, 1, 61, 5, 9, 2), 24));
  }
}
