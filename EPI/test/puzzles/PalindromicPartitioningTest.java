package puzzles;

import org.junit.Test;

import java.util.Arrays;

import static puzzles.PalindromicPartitioning.minCuts;
import static puzzles.PalindromicPartitioning.minimumPalindromicDecompositions;

/**
 * Created by pankaj on 1/31/16.
 */
public class PalindromicPartitioningTest {

    @Test
    public void testMinimumPalindromicPartitions() throws Exception {
        assert (3 == minCuts("0204451881"));
        assert (1 == minCuts("aab"));
        assert (0 == minCuts("bb"));
        assert (3 == minCuts("cabababcbc"));
        assert (42 == minCuts("eegiicgaeadbcfacfhifdbiehbgejcaeggcgbahfcajfhjjdgj"));
    }

    @Test
    public void testMinimumPalindromicDecompositions() throws Exception {
        assert (Arrays.asList("020", "44", "5", "1881").equals(minimumPalindromicDecompositions("0204451881")));
    }
}