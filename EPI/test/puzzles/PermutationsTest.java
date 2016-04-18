package puzzles;

import com.pholser.junit.quickcheck.ForAll;
import org.junit.Test;
import org.junit.contrib.theories.Theories;
import org.junit.contrib.theories.Theory;
import org.junit.runner.RunWith;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static puzzles.Permutations.*;

@RunWith(Theories.class)
public class PermutationsTest {

    @Theory
    public void compareNextAndPrevPermutation(@ForAll List<Integer> A) {
        List<Integer> prev = prevPermutation(A);
        if (prev == null) return;
        List<Integer> nextOfPrev = nextPermutation(prev);
        assert nextOfPrev.equals(A);
    }

    @Test
    public void testAllPermutations() throws Exception {
        allPermutations(Arrays.asList(1, 2, 3), System.out);

        assert allPermutations(Arrays.asList(1)).equals(
                Arrays.asList(
                        Arrays.asList(1)
                ));
        assert allPermutations(Arrays.asList(1, 2, 3)).equals(
                Arrays.asList(
                        Arrays.asList(1, 2, 3),
                        Arrays.asList(1, 3, 2),
                        Arrays.asList(2, 1, 3),
                        Arrays.asList(2, 3, 1),
                        Arrays.asList(3, 1, 2),
                        Arrays.asList(3, 2, 1)
                ));
    }

    @Test
    public void testNextPermutation() throws Exception {
        assert nextPermutation(Arrays.asList(1, 2, 3)).equals(Arrays.asList(1, 3, 2));
        assert nextPermutation(Arrays.asList(1, 3, 2)).equals(Arrays.asList(2, 1, 3));
        assert nextPermutation(Arrays.asList(2, 1, 3)).equals(Arrays.asList(2, 3, 1));
        assert nextPermutation(Arrays.asList(2, 3, 1)).equals(Arrays.asList(3, 1, 2));
        assert nextPermutation(Arrays.asList(3, 1, 2)).equals(Arrays.asList(3, 2, 1));
        assert nextPermutation(Arrays.asList(3, 2, 1)) == null;
    }

    @Test
    public void testPrevPermutation() throws Exception {
        assert prevPermutation(Arrays.asList(1, 2, 3)) == null;
        assert prevPermutation(Arrays.asList(1, 3, 2)).equals(Arrays.asList(1, 2, 3));
        assert prevPermutation(Arrays.asList(2, 1, 3)).equals(Arrays.asList(1, 3, 2));
        assert prevPermutation(Arrays.asList(2, 3, 1)).equals(Arrays.asList(2, 1, 3));
        assert prevPermutation(Arrays.asList(3, 1, 2)).equals(Arrays.asList(2, 3, 1));
        assert prevPermutation(Arrays.asList(3, 2, 1)).equals(Arrays.asList(3, 1, 2));
    }

    @Test
    public void testKthPermutation() throws Exception {
        List<Integer> sorted = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        List<Integer> curr = new ArrayList<>(sorted);
        for (int k = 1; k <= 3628800; k++) {
            assert kthPermutation(sorted, k).equals(curr);
            curr = nextPermutation(curr);
        }
    }

    @Test
    public void testAllPermutations1() throws Exception {
        assert allPermutations1(Arrays.asList(1)).equals(
                Arrays.asList(
                        Arrays.asList(1)
                ));
        assert allPermutations1(Arrays.asList(1, 2, 3)).equals(
                Arrays.asList(
                        Arrays.asList(1, 2, 3),
                        Arrays.asList(1, 3, 2),
                        Arrays.asList(2, 1, 3),
                        Arrays.asList(2, 3, 1),
                        Arrays.asList(3, 2, 1), //not sorted
                        Arrays.asList(3, 1, 2)
                ));
    }
}