package dp;

import com.sun.istack.internal.NotNull;

import java.util.List;

/**
 * http://jeffe.cs.illinois.edu/teaching/algorithms/notes/05-dynprog.pdf
 * Page - 25, Q18
 * Created by pankaj on 29/11/16.
 */
public class Q18 {
    /**
     * Time: O(M * N)
     * Space: O(N)
     */
    public static int largestSquare(@NotNull List<List<Integer>> A) {
        if (A.size() == 0 || A.get(0).size() == 0) return 0;
        if (!isMatrix(A)) throw new IllegalArgumentException("Not a rectangular grid!");
        int M = A.size(), N = A.get(0).size();
        int[] dp = new int[N], H = new int[N];
        int max = 0;
        for (int i = 0; i < M; i++) {
            int prev = 0, w = 0;
            for (int j = 0; j < N; j++) {
                int tmp = dp[j];
                w = A.get(i).get(j) == 0 ? 0 : 1 + w;
                H[j] = A.get(i).get(j) == 0 ? 0 : 1 + H[j];
                dp[j] = Math.min(prev + 1, Math.min(H[j], w));
                prev = tmp;
                max = Math.max(max, dp[j]);
            }
        }
        return max * max;
    }

    /**
     * Time: O(M * N * Min(M, N))
     * Space: O(M * N)
     */
    public static int largestSquareSlow(@NotNull List<List<Integer>> A) {
        if (A.size() == 0 || A.get(0).size() == 0) return 0;
        if (!isMatrix(A)) throw new IllegalArgumentException("Not a rectangular grid!");
        int M = A.size(), N = A.get(0).size();
        int[][] H = new int[M][N], V = new int[M][N];
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                H[i][j] = (j == 0 ? 0 : H[i][j - 1]) + (A.get(i).get(j) == 1 ? 1 : 0);
                V[i][j] = (i == 0 ? 0 : V[i - 1][j]) + (A.get(i).get(j) == 1 ? 1 : 0);
            }
        }
        int max = 0;
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = i, l = j; k < M && l < N; k++, l++) {
                    int s = k - i + 1;
                    if (V[k][l] - (i == 0 ? 0 : V[i - 1][l]) == s
                            && H[k][l] - (j == 0 ? 0 : H[k][j - 1]) == s) {
                        max = Math.max(max, s);
                    } else break;
                }
            }
        }
        return max * max;
    }

    static boolean isMatrix(@NotNull List<List<Integer>> A) {
        return A.stream().map(List::size).distinct().count() == 1;
    }

    /**
     * Time: O(M^2 * N^2)
     * Space: O(M * N)
     */
    public static int maximumSumRectangleSlow(@NotNull List<List<Integer>> A) {
        if (A.size() == 0 || A.get(0).size() == 0) return 0;
        if (!isMatrix(A)) throw new IllegalArgumentException("Not a rectangular grid!");
        int M = A.size(), N = A.get(0).size();
        int maxSum = Integer.MIN_VALUE;
        int[][] V = new int[M][N];
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                V[i][j] = (i == 0 ? 0 : V[i - 1][j]) + A.get(i).get(j);
            }
        }
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = i; k < M; k++) {
                    int sum = 0;
                    for (int l = j; l < M; l++) {
                        sum += V[k][l] - (i == 0 ? 0 : V[i - 1][l]);
                        maxSum = Math.max(maxSum, sum);
                    }
                }
            }
        }
        return maxSum;
    }

    /**
     * Time: O(M^2 * N)
     * Space: O(M * N)
     */
    public static int maximumSumRectangle(@NotNull List<List<Integer>> A) {
        if (A.size() == 0 || A.get(0).size() == 0) return 0;
        if (!isMatrix(A)) throw new IllegalArgumentException("Not a rectangular grid!");
        int M = A.size(), N = A.get(0).size();
        int maxSum = Integer.MIN_VALUE;
        int[][] V = new int[M][N];
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                V[i][j] = (i == 0 ? 0 : V[i - 1][j]) + A.get(i).get(j);
            }
        }
        for (int i = 0; i < M; i++) {
            for (int k = i; k < M; k++) {
                int maxEndingHere = 0;
                for (int j = 0; j < N; j++) {
                    int colSum = V[k][j] - (i == 0 ? 0 : V[i - 1][j]);
                    maxEndingHere = Math.max(maxEndingHere + colSum, colSum);
                    maxSum = Math.max(maxSum, maxEndingHere);
                }
            }
        }
        return maxSum;
    }
}
