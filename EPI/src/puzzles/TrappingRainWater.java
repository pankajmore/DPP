package puzzles;

import org.jetbrains.annotations.NotNull;

/** Created by Pankaj on 9/12/15. */
public class TrappingRainWater {
  /**
   * Time : O(n) Space : O(n)
   *
   * @param A array of non-negative integers
   * @return the capacity of the 1-D tank with unit width rectangle and height from A
   */
  public static int capacity(@NotNull int[] A) {
    int N = A.length;
    int[] L, R, H;
    L = new int[N + 2];
    H = new int[N + 2];
    R = new int[N + 2];
    System.arraycopy(A, 0, H, 1, N);
    for (int i = 1; i <= N; i++) {
      L[i] = Math.max(L[i - 1], H[i]);
      R[N - i + 1] = Math.max(R[N - i + 2], H[N - i + 1]);
    }
    int c = 0;
    for (int i = 1; i <= N; i++) {
      c += Math.max(Math.min(L[i - 1], R[i + 1]) - H[i], 0);
    }
    return c;
  }

  /**
   * Time : O(n) Space : O(1)
   *
   * @param A array of non-negative integers denoting the height of each unit-width rectangle
   * @return the maximum capacity of the container formed by A
   */
  public static int capacity1(@NotNull int[] A) {
    int N = A.length;
    int c = 0, maxSoFar = 0;
    int m = maxIndex(A);
    for (int i = 0; i < m; i++) {
      c += Math.max(maxSoFar - A[i], 0);
      maxSoFar = Math.max(maxSoFar, A[i]);
    }
    maxSoFar = 0;
    for (int i = N - 1; i > m; i--) {
      c += Math.max(maxSoFar - A[i], 0);
      maxSoFar = Math.max(maxSoFar, A[i]);
    }
    return c;
  }

  private static int maxIndex(@NotNull int[] A) {
    int mIndex = 0;
    int mVal = A[0];
    for (int i = 0; i < A.length; i++)
      if (A[i] > mVal) {
        mVal = A[i];
        mIndex = i;
      }
    return mIndex;
  }
}
