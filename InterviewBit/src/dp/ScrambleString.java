import java.util.*;

/**
 * Created by pankaj on 3/7/16.
 */
public class ScrambleString {
    /**
     * Time : O(N^4)
     * Space: O(N^3)
     *
     * @param s string of size N
     * @param t string of size N
     * @return true if t is a scramble of s
     */
    public static boolean scrambled(String s, String t) {
        int N = s.length();
        Map<List<Integer>, Boolean> cache = new HashMap<>();
        return scrambledHelper(s, t, 0, 0, N, cache);
    }

    public static boolean isScrambleDP(String s, String t) {
        int N = s.length();
        boolean[][][] dp = new boolean[N + 1][N + 1][N + 1];
        for (int i = N - 1; i >= 0; i--) {
            for (int j = N - 1; j >= 0; j--) {
                if (s.charAt(i) == t.charAt(j)) dp[i][j][1] = true;
                for (int l = 2; i + l <= N && j + l <= N; l++) {
                    for (int v = 1; v < l; v++) {
                        dp[i][j][l] |= dp[i][j][v] && dp[i + v][j + v][l - v]
                                || dp[i][j + l - v][v] && dp[i + v][j][l - v];
                    }
                }
            }
        }
        return dp[0][0][N];
    }

    public static boolean isScramble(String s, String t) {
        int N = s.length();
        if (s.equals(t)) return true;
        int[] count = new int[26];
        for (int i = 0; i < N; i++) {
            count[s.charAt(i) - 'a']++;
            count[t.charAt(i) - 'a']--;
        }
        for (int i = 0; i < 26; i++) if (count[i] != 0) return false;

        for (int i = 1; i < N; i++) {
            if (isScramble(s.substring(0, i), t.substring(0, i)) && isScramble(s.substring(i), t.substring(i)))
                return true;
            if (isScramble(s.substring(0, i), t.substring(N - i)) && isScramble(s.substring(i), t.substring(0, N - i)))
                return true;
        }
        return false;
    }

    private static boolean scrambledHelper2(String s, String t, Map<List<String>, Boolean> cache) {
        int N = s.length();
        if (N == 1) return s.charAt(0) == t.charAt(0);
        List<String> key = new ArrayList<>();
        key.add(s);
        key.add(t);
        if (cache.containsKey(key)) return cache.get(key);
        for (int i = 1; i < N; i++) {
            if (scrambledHelper2(s.substring(0, i), t.substring(0, i), cache)
                    && scrambledHelper2(s.substring(i, N), t.substring(i, N), cache)
                    || scrambledHelper2(s.substring(0, i), t.substring(N - i, N), cache)
                    && scrambledHelper2(s.substring(i, N), t.substring(0, N - i), cache)) {
                cache.put(key, true);
                return true;
            }
        }
        cache.put(key, false);
        return false;
    }

    private static boolean scrambledHelper(String s, String t, int i, int j, int l, Map<List<Integer>, Boolean> cache) {
        if (l == 1) return s.charAt(i) == t.charAt(j);
        List<Integer> key = Arrays.asList(i, j, l);
        if (cache.containsKey(key)) return cache.get(key);
        for (int v = 1; v < l; v++) {
            if ((scrambledHelper(s, t, i, j, v, cache) && scrambledHelper(s, t, i + v, j + v, l - v, cache))
                    || (scrambledHelper(s, t, i, j + l - v, v, cache) && scrambledHelper(s, t, i + v, j, l - v, cache))) {
                cache.put(key, true);
                return true;
            }
        }
        cache.put(key, false);
        return false;
    }
}
