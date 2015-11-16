package utils.graph;

import examples.graph.DirectedGraphs;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;

public class StronglyConnectedComponentsTest {

    @Test
    public void testSccs() throws Exception {
        Set<Set<Integer>> actual = new StronglyConnectedComponents(DirectedGraphs.twoNodeCycle).sccs();
        Set<Set<Integer>> expected = new HashSet<>();
        expected.add(new HashSet<>(Arrays.asList(0, 1)));
        assert actual.iterator().next().equals(expected.iterator().next());
    }
}