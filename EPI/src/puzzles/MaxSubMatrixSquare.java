package puzzles;

import java.util.List;

/**
 * Created by pankaj on 3/15/16.
 */
public class MaxSubMatrixSquare {
    /**
     * Time : O(M * N)
     * Space: O(M * N)
     *
     * @param A a 2D grid of size M x N containing 0' and 1's
     * @return area of the largest square containing all 1's
     */
    public static int maxSquareSubmatrix(List<List<Boolean>> A) {
        if (A.size() == 0 || A.get(0).size() == 0) return 0;
        int M = A.size(), N = A.get(0).size();
        int[][] H = new int[M][N], W = new int[M][N];
        for (int i = M - 1; i >= 0; i--) {
            for (int j = N - 1; j >= 0; j--) {
                if (!A.get(i).get(j)) {
                    H[i][j] = 0;
                    W[i][j] = 0;
                } else {
                    H[i][j] = i == M - 1 ? 1 : 1 + H[i + 1][j];
                    W[i][j] = j == N - 1 ? 1 : 1 + W[i][j + 1];
                }
            }
        }
        int maxSquareArea = 0;
        int[][] dp = new int[M][N];
        for (int i = M - 1; i >= 0; i--) {
            for (int j = N - 1; j >= 0; j--) {
                int side = Math.min(H[i][j], W[i][j]);
                if (i < M - 1 && j < N - 1) side = Math.min(side, dp[i + 1][j + 1] + 1);
                dp[i][j] = side;
                maxSquareArea = Math.max(maxSquareArea, side * side);
            }
        }
        return maxSquareArea;
    }

    /**
     * Time : O(M^2 * N^2 * Min(M, N))
     * Space: O(M * N)
     *
     * @param A a 2D grid of size M x N containing 0' and 1's
     * @return area of the largest square containing all 1's
     */
    public static int maxSquareSubmatrixBruteForce(List<List<Boolean>> A) {
        if (A.size() == 0 || A.get(0).size() == 0) return 0;
        int M = A.size(), N = A.get(0).size();
        int maxSquareArea = 0;
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                for (int side = 1; i + side <= M && j + side <= N; side++) {
                    boolean isSideFeasible = true;
                    int count = 0;
                    for (int a = i; a < i + side; a++) {
                        for (int b = j; b < j + side; b++) {
                            if (A.get(a).get(b)) count++;
                            else {
                                count = 0;
                                isSideFeasible = false;
                                break;
                            }
                        }
                        if (!isSideFeasible) break;
                    }
                    if (isSideFeasible) maxSquareArea = Math.max(maxSquareArea, count);
                }
            }
        }
        return maxSquareArea;
    }
}
