package utils.graph;

import examples.graph.DirectedWeightedGraphs;
import org.junit.Test;

import java.util.Arrays;

public class ShortestPathWithFewestEdgesTest {

  @Test
  public void testShortestPath() throws Exception {
    final Dijkstra dijkstra = new Dijkstra(DirectedWeightedGraphs.bookExample, 0);
    assert dijkstra.shortestPath(7) == 22;
    assert Arrays.asList(0, 2, 4, 3, 7).equals(dijkstra.shortestPathSequence(7));
  }
}
