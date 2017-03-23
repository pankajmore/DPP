package puzzles;

/** Created by pankaj on 4/25/16. */
public class Rotate2DArray {
  /**
   * Time : O(NxN) Space: O(1)
   *
   * @param A NxN 2D array
   * @return rotate A by 90 degree clockwise
   */
  public static int[][] rotate2DArray(int[][] A) {
    if (A.length == 0 || A[0].length == 0) return A;
    int N = A.length;
    for (int i = 0; i < N / 2; i++) {
      for (int j = i; j < N - 1 - i; j++) {
        int temp = A[i][j];
        A[i][j] = A[N - 1 - j][i];
        A[N - 1 - j][i] = A[N - 1 - i][N - 1 - j];
        A[N - 1 - i][N - 1 - j] = A[j][N - 1 - i];
        A[j][N - 1 - i] = temp;
      }
    }
    return A;
  }

  /**
   * Time : O(NxN) Space: O(NxN)
   *
   * @param A NxN 2D array
   * @return rotate A by 90 degree clockwise
   */
  public static int[][] rotate2DArray1(int[][] A) {
    if (A.length == 0 || A[0].length == 0) return A;
    int N = A.length;
    int[][] B = new int[N][N];
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < N; j++) {
        B[i][j] = A[j][i];
      }
    }
    for (int j = 0; j < N / 2; j++) {
      for (int i = 0; i < N; i++) {
        int temp = B[i][j];
        B[i][j] = B[i][N - 1 - j];
        B[i][N - 1 - j] = temp;
      }
    }
    return B;
  }
}
