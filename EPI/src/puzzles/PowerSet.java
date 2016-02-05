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

    /**
     * Generate all subsets of A of size k
     * Time : O(N^K)
     * Space : O(N)
     *
     * @param A a list of N integers
     * @param k integer 0 <= k <= N
     */
    public static void subsetsOfFixedSize(List<Integer> A, int k) {
        List<Boolean> chosen = new ArrayList<>(A.size());
        for (int i = 0; i < A.size(); i++) chosen.add(false);
        List<Integer> subset = new ArrayList<>();
        subsetsOfFixedSizeHelper(A, chosen, subset, k);
    }

    private static void subsetsOfFixedSizeHelper(List<Integer> A, List<Boolean> choosen, List<Integer> subset, int k) {
        if (k == 0) {
            System.out.println(subset.toString());
            return;
        }
        for (int i = 0; i < A.size(); i++) {
            if (!subset.isEmpty() && subset.get(subset.size() - 1) > A.get(i)) continue;
            if (choosen.get(i)) continue;
            choosen.set(i, true);
            subset.add(A.get(i));
            subsetsOfFixedSizeHelper(A, choosen, subset, k - 1);
            subset.remove(subset.size() - 1);
            choosen.set(i, false);
        }
    }

    public static List<List<Integer>> subsetsOfFixedSize1(List<Integer> A, int k) {
        List<List<Integer>> subsets = new ArrayList<>();
        if(k == 0) {
            subsets.add(new ArrayList<>());
            return subsets;
        }
        if (A.size() < k) return subsets;
        subsets.addAll(subsetsOfFixedSize1(A.subList(0, A.size() - 1), k));
        for (List<Integer> subset : subsetsOfFixedSize1(A.subList(0, A.size() - 1), k - 1)) {
            subset.add(A.get(A.size() - 1));
            subsets.add(subset);
        }
        return subsets;
    }
}
