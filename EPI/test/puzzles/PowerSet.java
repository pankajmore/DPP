package puzzles;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Pankaj on 1/11/16.
 * Various ways to compute the powerSet of a set
 */
public class PowerSet {
    /**
     * Time : O(N*2^N)
     * Space : O(N*2^N)
     *
     * @param A a list of size N
     * @return all the subsets of A
     */
    public static List<List<Integer>> generatePowerSet(List<Integer> A) {
        return generatePowerSetHelper(A, A.size() - 1);
    }

    private static List<List<Integer>> generatePowerSetHelper(List<Integer> A, int index) {
        List<List<Integer>> powerSet = new ArrayList<>();
        if (index == -1) {
            powerSet.add(new ArrayList<>());
            return powerSet;
        }
        List<List<Integer>> prevSubsets = generatePowerSetHelper(A, index - 1);
        powerSet.addAll(prevSubsets);
        for (List<Integer> subset : prevSubsets) {
            List<Integer> newSubset = new ArrayList<>();
            newSubset.addAll(subset);
            newSubset.add(A.get(index));
            powerSet.add(newSubset);
        }
        return powerSet;
    }

    /**
     * Prints all the subsets of A
     * Time : O(N*2^N)
     * Space : O(N)
     *
     * @param A a list of size N
     */
    public static void generatePowerSet1(List<Integer> A) {
        generatePowerSetHelper(A, 0, new ArrayList<>());
    }

    private static void generatePowerSetHelper(List<Integer> A, int index, List<Integer> subset) {
        if (index == A.size()) {
            System.out.println(subset);
            return;
        }
        generatePowerSetHelper(A, index + 1, subset);
        subset.add(A.get(index));
        generatePowerSetHelper(A, index + 1, subset);
        subset.remove(subset.size() - 1);
    }

    /**
     * Prints all the subsets of A
     * Time : O(N*2^N)
     * Space : O(N)
     *
     * @param A a list of size N
     */
    public static void generatePowerSetUsingBits(List<Integer> A) {
        int N = A.size();
        for (int bitset = 0; bitset < (1 << N); bitset++) {
            int currentBitset = bitset;
            List<Integer> subset = new ArrayList<>();
            for (Integer x : A) {
                if ((currentBitset & 1) == 1) subset.add(x);
                currentBitset >>= 1;
            }
            System.out.println(subset);
        }
    }
}
