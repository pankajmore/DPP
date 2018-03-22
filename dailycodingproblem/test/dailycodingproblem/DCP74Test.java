package dailycodingproblem;

import org.junit.jupiter.api.Test;

import static dailycodingproblem.DCP74.numberOfTimesInATable;
import static org.junit.jupiter.api.Assertions.assertEquals;

class DCP74Test {

  @Test
  void numberOfTimesInATableTest() {
    assertEquals(0, numberOfTimesInATable(0, 0));
    assertEquals(1, numberOfTimesInATable(1, 1));
    assertEquals(0, numberOfTimesInATable(1, 2));
    assertEquals(1, numberOfTimesInATable(2, 1));
    assertEquals(4, numberOfTimesInATable(6, 12));
  }
}