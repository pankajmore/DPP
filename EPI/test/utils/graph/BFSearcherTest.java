package utils.graph;

import examples.graph.DirectedGraphs;
import org.junit.Test;

public class BFSearcherTest {

  @Test
  public void testIsReachable() throws Exception {
    BFSearcher bfSearcher = new BFSearcher(DirectedGraphs.diamond, 0);
    assert bfSearcher.isReachable(0);
    assert bfSearcher.isReachable(1);
    assert bfSearcher.isReachable(2);
    assert bfSearcher.isReachable(3);

    bfSearcher = new BFSearcher(DirectedGraphs.diamond, 3);
    assert !bfSearcher.isReachable(0);
    assert !bfSearcher.isReachable(1);
    assert !bfSearcher.isReachable(2);
    assert bfSearcher.isReachable(3);

    bfSearcher = new BFSearcher(DirectedGraphs.diamond, 1);
    assert !bfSearcher.isReachable(0);
    assert bfSearcher.isReachable(1);
    assert !bfSearcher.isReachable(2);
    assert bfSearcher.isReachable(3);
  }
}
