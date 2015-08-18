package puzzles;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Pankaj on 8/9/15.
 */
public class ScoreCombination {
    /**
     * DP optimised solution
     * Time complexity : O(s*n) where n = scores.size()
     * Space Complexity : O(s)
     *
     * @param s      the score s
     * @param scores the list of scores
     * @return number of ways s can be scored using scores in W
     */
    public static int countCombinationsDP(int s, List<Integer> scores) {
        int[] A = new int[s + 1];
        A[0] = 1;
        for (Integer score : scores) {
            for (int j = score; j <= s; j++) A[j] += A[j - score];
        }
        return A[s];
    }

    /**
     * Recursive exponential algorithm
     *
     * @param s      the score s
     * @param scores the list of points
     * @return number of ways s can be scored using points in scores
     */
    public static int countCombinationsRecursive(int s, List<Integer> scores) {
        if (scores.isEmpty()) return 0;
        if (s == 0) return 1;
        int c = 0;
        c += countCombinationsRecursive(s, scores.subList(1, scores.size()));
        c += (s - scores.get(0)) >= 0 ? countCombinationsRecursive(s - scores.get(0), scores) : 0;
        return c;
    }

    public static List<List<Integer>> printCombinations(int s, List<Integer> scores) {
        List<List<Integer>> ans = new ArrayList<>();
        if (scores.size() == 1) {
            if (s % scores.get(0) == 0) {
                ans.add(new ArrayList<>());
                ans.get(0).add(s / scores.get(0));
            }
            return ans;
        }
        int x = scores.get(scores.size() - 1);
        List<Integer> tail = scores.subList(0, scores.size() - 1);
        ans = printCombinations(s, tail);
        s -= x;
        int i = 1;
        while (s >= 0) {
            for (List<Integer> l : printCombinations(s, tail)) {
                l.add(i);
                ans.add(l);
            }
            i++;
            s -= x;
        }
        return ans;
    }

    /**
     * Time Complexity : Exponential
     * Space Complexity : O(s/Scores_min)
     *
     * @param s      the score to achieve
     * @param scores the list of scores
     * @return number of permutations in which s can be scored
     */
    public static int countPermutationsRecursive(int s, List<Integer> scores) {
        if (s == 0) return 1;
        int c = 0;
        for (Integer score : scores) {
            c += s - score >= 0 ? countPermutationsRecursive(s - score, scores) : 0;
        }
        return c;
    }

    /**
     * Time Complexity : O(sn)
     * Space Complexity : O(s)
     *
     * @param s      the score to achieve
     * @param scores the list of scores
     * @return number of permutations in which s can be scored
     */
    public static int countPermutationsDP(int s, List<Integer> scores) {
        int[] A = new int[s + 1];
        A[0] = 1;
        for (int i = 1; i <= s; i++) {
            for (Integer score : scores)
                A[i] += i - score >= 0 ? A[i - score] : 0;
        }
        return A[s];
    }

    public static List<List<Integer>> printPermutations(int s, List<Integer> scores) {
        List<List<Integer>> ans = new ArrayList<>();
        if (s == 0) ans.add(new ArrayList<>());
        else
            scores.stream().filter(score -> s - score >= 0).forEach(score -> {
                for (List<Integer> l : printPermutations(s - score, scores)) {
                    l.add(score);
                    ans.add(l);
                }
            });
        return ans;
    }
}
