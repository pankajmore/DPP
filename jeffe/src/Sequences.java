import com.sun.istack.internal.NotNull;

import java.util.Arrays;
import java.util.List;

/**
 * http://jeffe.cs.illinois.edu/teaching/algorithms/notes/05-dynprog.pdf
 * Page - 19, Q3
 * Created by pankaj on 9/20/16.
 */
public class Sequences {
    public static <T> int longestCommonSubsequence(List<T> A, List<T> B) {
        int M = A.size();
        int N = B.size();
        int[][] dp = new int[M + 1][N + 1];
        for (int i = 1; i <= M; i++) {
            for (int j = 1; j <= N; j++) {
                if (A.get(i - 1).equals(B.get(j - 1))) dp[i][j] = dp[i - 1][j - 1] + 1;
                else dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
            }
        }
        return dp[M][N];
    }

    public static <T> int shortestCommonSupersequence(List<T> A, List<T> B) {
        return A.size() + B.size() - longestCommonSubsequence(A, B);
    }

    public static <T> int editDistance(List<T> A, List<T> B) {
        return A.size() + B.size() - 2 * longestCommonSubsequence(A, B);
    }

    public static <T extends Comparable<T>> int longestMonotonicSubsequence(List<T> A, boolean increasing) {
        int N = A.size();
        int[] dp = new int[N];
        int max = 0;
        for (int i = 1; i < N; i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] + 1 > dp[i] && A.get(j).compareTo(A.get(i)) < 0 == increasing) dp[i] = dp[j] + 1;
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }

    public static <T extends Comparable<T>> int longestBitonicSubsequence(List<T> A) {
        int N = A.size();
        if (N < 3) return 0;
        int[] left = new int[N];
        int[] right = new int[N];
        int max = 0;
        for (int i = 0; i < N; i++) {
            int k = N - 1 - i;
            for (int j = 0; j < i; j++) {
                int l = N - 1 - j;
                if (left[j] + 1 > left[i] && A.get(j).compareTo(A.get(i)) < 0)
                    left[i] = left[j] + 1;
                if (right[l] + 1 > right[k] && A.get(j).compareTo(A.get(i)) < 0)
                    right[k] = right[l] + 1;
            }
        }
        for (int i = 1; i < N - 1; i++) {
            max = Math.max(max, left[i] + right[i]);
        }
        return max;
    }

    public static <T extends Comparable<T>> int longestOscillatingSubsequence(List<T> A) {
        int N = A.size();
        int[] odd = new int[N];
        int[] even = new int[N];
        Arrays.fill(odd, 1);
        Arrays.fill(even, 1);
        int max = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < i; j++) {
                int cmp = A.get(i).compareTo(A.get(j));
                if (cmp > 0) {
                    even[i] = Math.max(even[i], odd[j] + 1);
                } else if (cmp < 0) {
                    odd[i] = Math.max(odd[i], even[j] + 1);
                }
            }
            max = Math.max(even[i], odd[i]);
        }
        return max;
    }

    public static <T extends Comparable<T>> int shortestOscillatingSupersequence(@NotNull List<T> A) {
        boolean even = true;
        int N = A.size(), cnt = N;
        for (int i = 0; i < N - 1; i++) {
            int cmp = A.get(i).compareTo(A.get(i + 1));
            if ((even && cmp > 0) || (!even && cmp < 0)) {
                even ^= true;
            } else if ((even && cmp <= 0) || (!even && cmp >= 0)) {
                cnt++;
            }
        }
        return cnt;
    }
}
