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
}
