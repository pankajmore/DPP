package dp;

import com.sun.istack.internal.NotNull;

import java.util.List;

/**
 * http://jeffe.cs.illinois.edu/teaching/algorithms/notes/05-dynprog.pdf
 * Page - 25, Q18
 * Created by pankaj on 29/11/16.
 */
public class Q18 {
    public static int largestSquare(@NotNull List<List<Integer>> A) {
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
                        max = Math.max(max, s * s);
                    } else break;
                }
            }
        }
        return max;
    }

    public static int largestSquareSlow(@NotNull List<List<Integer>> A) {
        if (A.size() == 0 || A.get(0).size() == 0) return 0;
        if (!isMatrix(A)) throw new IllegalArgumentException("Not a rectangular grid!");
        int M = A.size(), N = A.get(0).size();
        int max = 0;
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = i, l = j; k < M && l < N; k++, l++) {
                    int s = k - i + 1;
                    if (isSolid(A, i, j, k, l)) {
                        max = Math.max(max, s * s);
                    } else break;
                }
            }
        }
        return max;
    }

    private static boolean isSolid(List<List<Integer>> A, int x1, int y1, int x2, int y2) {
        for (int i = x1; i <= x2; i++) {
            for (int j = y1; j <= y2; j++) {
                if (A.get(i).get(j) != 1) return false;
            }
        }
        return true;
    }

    public static boolean isMatrix(@NotNull List<List<Integer>> A) {
        return A.stream().map(List::size).distinct().count() == 1;
    }
}
