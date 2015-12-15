package puzzles;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Created by Pankaj on 12/15/15.
 */
public class WordBreaking {
    /**
     * Time: O(s.length()^3)
     * Space: O(n)
     *
     * @param s    the string to break
     * @param dict the dictionary of words
     * @return List of sequence of words which concatenate to s if such a list exists
     * else null
     */
    public static List<String> wordBreaking(String s, Set<String> dict) {
        boolean[] solutions = buildSolutionDP(s, dict);
        return backtrack(s, dict, solutions);
    }

    private static List<String> backtrack(String s, Set<String> dict, boolean[] solutions) {
        int N = s.length();
        if (!solutions[N]) return null;
        List<String> words = new ArrayList<>();
        int start = 0, end = 0;
        while (++end <= N) {
            if (solutions[end] && dict.contains(s.substring(start, end))) {
                words.add(s.substring(start, end));
                start = end;
            }
        }
        return words;
    }

    private static boolean[] buildSolutionDP(String s, Set<String> dict) {
        int N = s.length();
        boolean[] dp = new boolean[N + 1];
        dp[0] = true;
        for (int i = 1; i <= N; i++) {
            for (int k = 0; k < i; k++) {
                if (dp[k] && dict.contains(s.substring(k, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp;
    }
}
