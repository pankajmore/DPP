package utils.graph;

import examples.graph.DirectedGraphs;
import org.junit.Test;

import java.util.Arrays;

public class TopologicalSorterTest {

  @Test
  public void testTopologicalOrder() throws Exception {
    int[] expected = {0, 2, 1, 3};
    int[] actual = new TopologicalSorter(DirectedGraphs.diamond).topologicalOrder();
    assert Arrays.equals(actual, expected);
  }
}
