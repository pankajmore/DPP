package puzzles;

import java.util.Arrays;
import java.util.List;

/** Created by pankaj on 4/13/16. */
public class MaxProductTriplets {
  /**
   * Time : O(N) Space: O(1)
   *
   * @param A list of N integers
   * @return return the max product of all possible triplets, INT_MIN if N < 3
   */
  public static int maxProductTriplets(List<Integer> A) {
    int N = A.size();
    if (N < 3) return Integer.MIN_VALUE;
    int[] max = new int[3], min = new int[2];
    Arrays.fill(max, Integer.MIN_VALUE);
    Arrays.fill(min, Integer.MAX_VALUE);
    for (int x : A) {
      if (x > max[0]) max[0] = x;
      Arrays.sort(max);
      if (x < min[1]) min[1] = x;
      Arrays.sort(min);
    }
    return Math.max(max[0] * max[1] * max[2], max[2] * min[0] * min[1]);
  }

  /**
   * Time : O(N^3) Space: O(1)
   *
   * @param A list of N integers
   * @return return the max product of all possible triplets, INT_MIN if N < 3
   */
  public static int maxProductTriplets1(List<Integer> A) {
    int maxProduct = Integer.MIN_VALUE, N = A.size();
    for (int i = 0; i < N; i++) {
      for (int j = i + 1; j < N; j++) {
        for (int k = j + 1; k < N; k++) {
          maxProduct = Math.max(maxProduct, A.get(i) * A.get(j) * A.get(k));
        }
      }
    }
    return maxProduct;
  }
}
