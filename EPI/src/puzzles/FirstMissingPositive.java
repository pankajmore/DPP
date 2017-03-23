package puzzles;

import java.util.Arrays;

/** Created by pankaj on 2/15/16. */
public class FirstMissingPositive {
  /**
   * Time : O(N) Space : O(1)
   *
   * <p>Does not preserve the ordering in original array
   *
   * @param A array of size N
   * @return the first positive integer missing in A
   */
  public static int findFirstMissingPositiveEntry(int[] A) {
    int N = A.length;
    for (int i = 0; i < N; i++) {
      while (i > 0 && i <= N && A[i] != A[A[i] - 1] && A[i] != i + 1) {
        int temp = A[A[i] - 1];
        A[A[i] - 1] = A[i];
        A[i] = temp;
      }
    }
    for (int i = 0; i < N; i++) {
      if (A[i] != i + 1) return i + 1;
    }
    return N + 1;
  }

  /**
   * Time : O(N) Space : O(N)
   *
   * @param A array of size N
   * @return the first positive integer missing in A
   */
  public static int findFirstMissingPositiveEntry1(int[] A) {
    int N = A.length;
    int[] B = new int[N + 1];
    for (int i = 0; i < N; i++) {
      if (A[i] > 0 && A[i] <= N) B[A[i] - 1] = 1;
    }
    for (int i = 0; i <= N; i++) if (B[i] == 0) return i + 1;
    return N + 1;
  }

  /**
   * Time : O(NLog(N)) Space : O(1)
   *
   * @param A array of size N
   * @return the first positive integer missing in A
   */
  public static int findFirstMissingPositiveEntry2(int[] A) {
    Arrays.sort(A);
    for (int i = 0; i < A.length; i++) if (A[i] != i + 1) return i + 1;
    return A.length + 1;
  }
}
