package utils.graph;

import examples.graph.DirectedGraphs;
import org.junit.Test;

public class CycleDetectorTest {

    @Test
    public void testIsDAG() throws Exception {
        assert !(new CycleDetector(DirectedGraphs.twoNodeCycle).isDAG());
        assert new CycleDetector(DirectedGraphs.diamond).isDAG();
    }
}