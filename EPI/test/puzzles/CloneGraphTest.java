package puzzles;

import org.junit.Test;
import puzzles.CloneGraph.DirectedGraph;

/**
 * Created by pankaj on 3/18/16.
 */
public class CloneGraphTest {

    @Test
    public void testDiamondGraph() throws Exception {
        DirectedGraph a = new DirectedGraph(0);
        DirectedGraph b = new DirectedGraph(1);
        DirectedGraph c = new DirectedGraph(2);
        DirectedGraph d = new DirectedGraph(3);
        a.neighbors.add(b);
        a.neighbors.add(c);
        b.neighbors.add(d);
        c.neighbors.add(d);
        DirectedGraph copy = CloneGraph.clone(a);
        assert a.deepEquals(copy);
    }

    @Test
    public void testSelfLoop() throws Exception {
        DirectedGraph selfLoop = new DirectedGraph(0);
        selfLoop.neighbors.add(selfLoop);

        DirectedGraph copy = CloneGraph.clone(selfLoop);
        assert selfLoop.deepEquals(copy);
    }

    @Test
    public void testCycle() throws Exception {
        DirectedGraph a = new DirectedGraph(0);
        DirectedGraph b = new DirectedGraph(1);
        DirectedGraph c = new DirectedGraph(2);
        a.neighbors.add(b);
        b.neighbors.add(c);
        c.neighbors.add(a);
        DirectedGraph copy = CloneGraph.clone(a);
        assert a.deepEquals(copy);
    }
}