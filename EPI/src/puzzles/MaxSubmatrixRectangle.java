package puzzles;

import java.util.List;

/**
 * Created by pankaj on 3/14/16.
 */
public class MaxSubmatrixRectangle {
    /**
     * Time : O(M^2N)
     * Space: O(MN)
     *
     * @param A a 2D grid of size M x N containing 0' and 1's
     * @return the area of the largest rectangle containing all 1's
     */
    public int maxRectangleSubmatrix(List<List<Boolean>> A) {
        if (A.size() == 0 || A.get(0).size() == 0) return 0;
        int M = A.size(), N = A.get(0).size();
        int[][] W = buildWidth(A, M, N);
        int best = 0;
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                int minWidth = W[i][j];
                for (int r = 0; r < M && A.get(r).get(j); r++) {
                    minWidth = Math.min(minWidth, W[r][j]);
                    best = Math.max(best, (r - i + 1) * minWidth);
                }
            }
        }
        return best;
    }

    private int[][] buildWidth(List<List<Boolean>> A, int M, int N) {
        int[][] W = new int[M][N];
        for (int i = 0; i < M; i++) {
            for (int j = N - 1; j >= 0; j--) {
                if (!A.get(i).get(j)) W[i][j] = 0;
                else W[i][j] = 1 + (j == N - 1 ? 0 : W[i][j + 1]);
            }
        }
        return W;
    }
}
