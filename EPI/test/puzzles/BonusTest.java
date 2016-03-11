package puzzles;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static puzzles.Bonus.calculateBonus;

/**
 * Created by pankaj on 3/11/16.
 */
public class BonusTest {

    @Test
    public void testComputeBonus() throws Exception {
        assert calculateBonus(Arrays.asList(1, 2, 4, 3, 8, 5, 6)).equals(Arrays.asList(1, 2, 3, 1, 2, 1, 2));

        List<Integer> a = Arrays.asList(1, 2, 2);
        List<Integer> goldenA = Arrays.asList(1, 2, 1);
        assert(calculateBonus(a).equals(goldenA));
        a = Arrays.asList(1, 2, 3, 2, 1);
        goldenA = Arrays.asList(1, 2, 3, 2, 1);
        assert(calculateBonus(a).equals(goldenA));
        a = Arrays.asList(300, 400, 500, 200);
        goldenA = Arrays.asList(1, 2, 3, 1);
        assert(calculateBonus(a).equals(goldenA));
    }
}