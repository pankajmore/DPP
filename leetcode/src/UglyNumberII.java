/** https://leetcode.com/problems/ugly-number-ii/ Created by pankaj on 13/02/17. */
public class UglyNumberII {
  public int nthUglyNumber(int N) {
    int[] A = new int[N];
    A[0] = 1;
    int x = 2, y = 3, z = 5, i = 0, j = 0, k = 0;
    for (int idx = 1; idx < N; idx++) {
      int min = Math.min(x, Math.min(y, z));
      A[idx] = min;
      if (x == min) x = 2 * A[++i];
      if (y == min) y = 3 * A[++j];
      if (z == min) z = 5 * A[++k];
    }
    return A[N - 1];
  }
}
