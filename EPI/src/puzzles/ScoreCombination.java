package puzzles;

import java.util.List;

/**
 * Created by Pankaj on 8/9/15.
 */
public class ScoreCombination {
    public static int countCombinations(int s, List<Integer> W) {
        if (s == 0 || W.size() == 0) return 0;
        if (W.size() == 1) return s % W.get(0) == 0 ? 1 : 0;
        int x = W.get(W.size() - 1), c = 0;
        List<Integer> tail = W.subList(0, W.size() - 1);
        while (s >= 0) {
            c += countCombinations(s, tail);
            s -= x;
        }
        return c;
    }
}
