package puzzles;

import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Pankaj on 12/8/15.
 */
public class Permutations {

    /**
     * Time: O(n*n!)
     * Space: O(n*n!)
     *
     * @param permutation a starting permutation of integers
     * @return return all the permutations belonging to the same set of integers
     */
    public static List<List<Integer>> allPermutations(List<Integer> permutation) {
        Collections.sort(permutation);
        List<List<Integer>> allPermutations = new ArrayList<>();
        while (permutation != null) {
            allPermutations.add(permutation);
            permutation = nextPermutation(permutation);
        }
        return allPermutations;
    }

    public static void allPermutations(List<Integer> permutation, OutputStream stream) {
        final PrintWriter printWriter = new PrintWriter(stream);
        while (permutation != null) {
            printWriter.println(permutation);
            permutation = nextPermutation(permutation);
        }
    }

    /**
     * Time: O(n)
     * Space: O(n)
     *
     * @param permutation input sequence
     * @return next sequence in the order of permutation rank
     * else null if it is the highest ranked permutation
     */
    public static List<Integer> nextPermutation(List<Integer> permutation) {
        permutation = new ArrayList<>(permutation);
        int i = inflectionPoint(permutation);
        if (i < 0) return null;
        int j = findReplacementForInflectionPoint(permutation, i);
        assert j != -1;
        swap(permutation, i, j);
        j = permutation.size() - 1;
        i += 1;
        while (i < j) swap(permutation, i++, j--);
        return permutation;
    }

    private static void swap(List<Integer> permutation, int i, int j) {
        Integer temp = permutation.get(i);
        permutation.set(i, permutation.get(j));
        permutation.set(j, temp);
    }

    private static int findReplacementForInflectionPoint(List<Integer> permutation, int i) {
        int j = permutation.size();
        Integer x = permutation.get(i);
        while (--j > i) {
            if (permutation.get(j) > x) return j;
        }
        return -1;
    }

    /**
     * The elements from end should increase and then decrease
     *
     * @param permutation the input permutation
     * @return the index of the first element (from end) which is less than the element after it
     * else -1 if this is the highest rank permutation.
     */
    private static int inflectionPoint(List<Integer> permutation) {
        int i = permutation.size() - 1;
        while (i > 0) {
            if (permutation.get(i) > permutation.get(i - 1)) return i - 1;
            --i;
        }
        return -1;
    }
}
