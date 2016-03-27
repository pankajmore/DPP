import java.util.Arrays;

public class EllysSocks {

    public int getDifference(int[] S, int P) {
        int N = S.length;
        Arrays.sort(S);
        int[][] dp = new int[N][P + 1];
        for (int i = 0; i < N; i++) {
            for (int p = 1; p <= P; p++) {
                if (i + 1 < 2 * p) dp[i][p] = Integer.MAX_VALUE;
                else {
                    int d = S[i] - S[i - 1];
                    if (d > dp[i - 1][p]) dp[i][p] = dp[i - 1][p];
                    else dp[i][p] = Math.max(d, i >= 2 ? dp[i - 2][p - 1] : 0);
                }
            }
        }
        return dp[N - 1][P];
    }
}
