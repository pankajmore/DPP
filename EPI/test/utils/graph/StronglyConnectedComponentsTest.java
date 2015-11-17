package utils.graph;

import examples.graph.DirectedGraphs;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class StronglyConnectedComponentsTest {

    @Test
    public void testSccs() throws Exception {
        Set<Set<Integer>> actual = new StronglyConnectedComponents(DirectedGraphs.twoNodeCycle).sccs();
        Set<Set<Integer>> expected = new HashSet<>();
        expected.add(new HashSet<>(Arrays.asList(0, 1)));
        assert compare(actual, expected);

        actual = new StronglyConnectedComponents(DirectedGraphs.wikiExample).sccs();
        expected.clear();
        expected.add(new HashSet<>(Arrays.asList(0, 1, 4)));
        expected.add(new HashSet<>(Arrays.asList(2, 3, 7)));
        expected.add(new HashSet<>(Arrays.asList(5, 6)));
        assert compare(actual, expected);
    }

    private boolean compare(Set<Set<Integer>> s1, Set<Set<Integer>> s2) {
        if (s1.size() != s2.size()) return false;
        for (Set<Integer> aS1 : s1) {
            if (!s2.contains(aS1))
                return false;
        }
        return true;
    }
}