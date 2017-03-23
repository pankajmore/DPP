package puzzles;

import java.util.ArrayList;
import java.util.List;

import static puzzles.LargestRectangleUnderSkyline.calculateLargestRectangle;

/** Created by pankaj on 3/14/16. */
public class MaxSubmatrixRectangle {
  /**
   * Time : O(M * N) Space: O(N)
   *
   * @param A a 2D grid of size M x N containing 0' and 1's
   * @return the area of the largest rectangle containing all 1's
   */
  public static int maxRectangleSubmatrixFast(List<List<Boolean>> A) {
    if (A.size() == 0 || A.get(0).size() == 0) return 0;
    int M = A.size(), N = A.get(0).size();
    List<Integer> skyline = new ArrayList<>();
    for (int j = 0; j < N; j++) skyline.add(0);
    int maxRectangleArea = 0;
    for (int i = 0; i < M; i++) {
      for (int j = 0; j < N; j++) {
        if (!A.get(i).get(j)) skyline.set(j, 0);
        else {
          skyline.set(j, i == 0 ? 1 : 1 + skyline.get(j));
        }
      }
      maxRectangleArea = Math.max(maxRectangleArea, calculateLargestRectangle(skyline));
    }
    return maxRectangleArea;
  }

  /**
   * Time : O(M^2 * N) Space: O(M * N)
   *
   * @param A a 2D grid of size M x N containing 0' and 1's
   * @return the area of the largest rectangle containing all 1's
   */
  public static int maxRectangleSubmatrix(List<List<Boolean>> A) {
    if (A.size() == 0 || A.get(0).size() == 0) return 0;
    int M = A.size(), N = A.get(0).size();
    int[][] W = buildWidth(A, M, N);
    int best = 0;
    for (int i = 0; i < M; i++) {
      for (int j = 0; j < N; j++) {
        int minWidth = W[i][j];
        for (int r = i; r < M && A.get(r).get(j); r++) {
          minWidth = Math.min(minWidth, W[r][j]);
          best = Math.max(best, (r - i + 1) * minWidth);
        }
      }
    }
    return best;
  }

  /**
   * Time : O(M^3 * N^3) Space: O(1)
   *
   * @param A a 2D grid of size M x N containing 0' and 1's
   * @return area of the largest rectangle containing all 1's
   */
  public static int maxRectangleSubmatrixBruteForce(List<List<Boolean>> A) {
    if (A.size() == 0 || A.get(0).size() == 0) return 0;
    int M = A.size(), N = A.size();
    int maxRectangleArea = 0;
    for (int i = 0; i < M; i++) {
      for (int j = 0; j < N; j++) {
        for (int k = i; k < M; k++) {
          for (int l = j; l < M; l++) {
            boolean isFeasible = true;
            int count = 0;
            for (int a = i; a <= k; a++) {
              for (int b = j; b <= l; b++) {
                if (A.get(a).get(b)) count++;
                else {
                  count = 0;
                  isFeasible = false;
                  break;
                }
              }
              if (!isFeasible) break;
            }
            if (isFeasible) maxRectangleArea = Math.max(maxRectangleArea, count);
          }
        }
      }
    }
    return maxRectangleArea;
  }

  private static int[][] buildWidth(List<List<Boolean>> A, int M, int N) {
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
