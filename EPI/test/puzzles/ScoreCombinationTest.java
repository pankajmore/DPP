package puzzles;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class ScoreCombinationTest {
    @Test
    public void testBookExample() {
        int s = 12;
        List<Integer> W = new ArrayList<Integer>();
        W.add(2);
        W.add(3);
        W.add(7);

        assert (4 == ScoreCombination.countCombinationsRecursive(s, W));
        assert (4 == ScoreCombination.countCombinationsDP(s, W));

        assert (18 == ScoreCombination.countPermutationsRecursive(s, W));
        assert (18 == ScoreCombination.countPermutationsDP(s, W));

        List<List<Integer>> ans = ScoreCombination.printCombinations(s, W);
        List<List<Integer>> expected = new ArrayList<>();
        List<Integer> l = new ArrayList<>();
        l.add(6);
        expected.add(l);
        l = new ArrayList<>();
        l.add(3);
        l.add(2);
        expected.add(l);
        l = new ArrayList<>();
        l.add(0);
        l.add(4);
        expected.add(l);
        l = new ArrayList<>();
        l.add(1);
        l.add(1);
        l.add(1);
        expected.add(l);
        assert (ans.equals(expected));
    }

}