import java.util.List;

/**
 * http://jeffe.cs.illinois.edu/teaching/algorithms/notes/05-dynprog.pdf
 * Page - 20, Q6
 * Created by pankaj on 08/11/16.
 */
public class Q6 {
    public static long maxScore(List<Integer> score, List<Integer> wait) {
        int N = score.size();
        assert N == wait.size();
        if (N == 0) return 0;
        int[] dp = new int[N];
        int max = 0;
        for (int i = 0; i < N; i++) {
            dp[i] = score.get(i);
            for (int j = 0; j < i; j++) {
                if (j + wait.get(j) < i) {
                    dp[i] = Math.max(dp[i], dp[j] + score.get(i));
                }
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }
}
