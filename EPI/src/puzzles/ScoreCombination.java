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

    public static List<List<Integer>> listCombinations(int s, List<Integer> scores) {
        List<List<Integer>> ans = new ArrayList<>();
        ArrayList<Integer> l = new ArrayList<>();
        if (s < 0) return ans;
        if (s == 0) {
            for (int i = 0; i < scores.size(); i++) l.add(0);
            ans.add(l);
            return ans;
        } else if (scores.size() == 1) {
            if (s % scores.get(0) == 0) {
                l.add(s / scores.get(0));
                ans.add(l);
            }
            return ans;
        }
        for (List<Integer> list : listCombinations(s, scores.subList(0, scores.size() - 1))) {
            list.add(0);
            ans.add(list);
        }
        for (List<Integer> list : listCombinations(s - scores.get(scores.size() - 1), scores)) {
            list.set(list.size() - 1, list.get(list.size() - 1) + 1);
            ans.add(list);
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

    public static List<List<Integer>> listPermutations(int s, List<Integer> scores) {
        List<List<Integer>> ans = new ArrayList<>();
        if (s == 0) ans.add(new ArrayList<>());
        else
            scores.stream().filter(score -> s - score >= 0).forEach(score -> {
                for (List<Integer> l : listPermutations(s - score, scores)) {
                    l.add(score);
                    ans.add(l);
                }
            });
        return ans;
    }

    /**
     * Time : Exponential
     * Space : Exponential
     *
     * @param s
     * @param scores
     * @return
     */
    public static List<List<Integer>> listPermutationsDP(int s, List<Integer> scores) {
        List<List<List<Integer>>> A = new ArrayList<>();
        for (int i = 0; i <= s; i++) A.add(new ArrayList<>());
        A.get(0).add(new ArrayList<>());
        for (int i = 1; i <= s; i++) {
            for (Integer score : scores) {
                if (i - score < 0) continue;
                for (List<Integer> l : A.get(i - score)) {
                    ArrayList<Integer> newl = new ArrayList<>(l);
                    newl.add(score);
                    A.get(i).add(newl);
                }
            }
        }
        return A.get(s);
    }

    public static void printPermutations(int s, List<Integer> scores, List<Integer> l) {
        if (s == 0) {
            System.out.println(l);
        } else
            scores.stream().filter(score -> s - score >= 0).forEach(score -> {
                ArrayList<Integer> ll = new ArrayList<>(l);
                ll.add(score);
                printPermutations(s - score, scores, ll);
            });
    }
}
