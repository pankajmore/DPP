package dp;

import com.sun.istack.internal.NotNull;

import java.util.List;

/**
 * http://jeffe.cs.illinois.edu/teaching/algorithms/notes/05-dynprog.pdf
 * Page - 20, Q4
 * Created by pankaj on 11/4/16.
 */
public class NumberOfSubsequences {
    /**
     * Time: O(N * K)
     * Space: O(K)
     *
     * @param A a sequence of length N
     * @param B a sequence of length M
     * @return the number of times B occurs as a sub-sequence in A
     */
    public static int numberOfSubsequences(@NotNull List<Integer> A, @NotNull List<Integer> B) {
        int N = A.size(), K = B.size();
        int[] dp = new int[K + 1];
        dp[0] = 1;
        for (int i = 1; i <= N; i++) {
            int prev = dp[0];
            for (int j = 1; j <= K; j++) {
                int temp = dp[j];
                dp[j] += A.get(i - 1).equals(B.get(j - 1)) ? prev : 0;
                prev = temp;
            }
        }
        return dp[K];
    }

    public static int numberOfSubsequencesSlow(@NotNull List<Integer> A, @NotNull List<Integer> B) {
        int cnt = 0, N = A.size();
        for (int i = 0; i < 1 << N; i++) {
            if (Integer.bitCount(i) != B.size()) continue;
            List<Integer> subSeq = Sequences.subset(A, i);
            if (subSeq.equals(B)) cnt++;
        }
        return cnt;
    }
}
