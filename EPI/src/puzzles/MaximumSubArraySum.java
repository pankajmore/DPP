package puzzles;

import puzzles.SubseqCover.SubArray;

import java.util.List;

/** Created by pankaj on 1/16/16. */
public class MaximumSubArraySum {
  /**
   * Time : O(N) Space : O(1)
   *
   * @param A a list of N integers
   * @return the sub-array [i,j] such that sum(A[i..j-1]) is maximum
   */
  public static SubArray findMaximumSumSubArray(List<Integer> A) {
    int N = A.size(), min_s = 0, min_i = -1, s = 0, best_sum = 0;
    SubArray bestSubArray = new SubArray(0, 0);
    for (int i = 0; i < N; i++) {
      s += A.get(i);
      if (s < min_s) {
        min_s = s;
        min_i = i;
      }
      if (s - min_s > best_sum) {
        best_sum = s - min_s;
        bestSubArray = new SubArray(min_i + 1, i + 1);
      }
    }
    return bestSubArray;
  }

  /**
   * Time : O(N) Space : O(1)
   *
   * @param A a list of N integers
   * @return the maximum sub array sum
   */
  public static int findMaximumSubArraySum(List<Integer> A) {
    int best_sum = 0, sum = 0, min_sum = 0;
    for (Integer x : A) {
      sum += x;
      if (sum < min_sum) min_sum = sum;
      best_sum = Math.max(best_sum, sum - min_sum);
    }
    return best_sum;
  }

  /**
   * Time : O(N) Space : O(N)
   *
   * @param A a *circular* list of N integers
   * @return the maximum sub-array sum, the sub-array may wrap around
   */
  public static int findMaximumSumSubArrayCircular(List<Integer> A) {
    return Math.max(findMaximumSubArraySum(A), findCircularMaxSubArraySum(A));
  }

  /**
   * Time : O(N) Space : O(1)
   *
   * @param A a *circular* list of N integers
   * @return the maximum sub-array sum, the sub-array may wrap around
   */
  public static int findMaximumSumSubArrayCircular1(List<Integer> A) {
    int sum = A.stream().reduce(0, (a, b) -> a + b);
    return Math.max(
        findOptimumSubArrayUsingComp(A, new MaximumSubArraySum.MaxComparator()),
        sum - findOptimumSubArrayUsingComp(A, new MaximumSubArraySum.MinComparator()));
  }

  /**
   * Time : O(N) Space : O(N)
   *
   * @param A a *circular* list of N integers
   * @return the maximum sub-array sum that *must* wrap around
   */
  public static int findCircularMaxSubArraySum(List<Integer> A) {
    if (A.size() == 0) return 0;
    int N = A.size();
    int[] maxBegin = new int[N], maxEnd = new int[N];
    maxBegin[0] = A.get(0);
    int sum = A.get(0);
    for (int i = 1; i < N; i++) {
      sum += A.get(i);
      maxBegin[i] = Math.max(maxBegin[i - 1], sum);
    }
    maxEnd[N - 1] = 0;
    sum = 0;
    for (int i = N - 2; i >= 0; i--) {
      sum += A.get(i + 1);
      maxEnd[i] = Math.max(maxEnd[i + 1], sum);
    }
    int circularSum = 0;
    for (int i = 0; i < N; i++) {
      circularSum = Math.max(circularSum, maxBegin[i] + maxEnd[i]);
    }
    return circularSum;
  }

  private static int findOptimumSubArrayUsingComp(List<Integer> A, IntegerComparator comp) {
    int till = 0, overall = 0;
    for (Integer x : A) {
      till = comp.compare(till + x, x);
      overall = comp.compare(overall, till);
    }
    return overall;
  }

  private interface IntegerComparator {
    Integer compare(Integer o1, Integer o2);
  }

  private static class MaxComparator implements IntegerComparator {
    @Override
    public Integer compare(Integer o1, Integer o2) {
      return o1 > o2 ? o1 : o2;
    }
  }

  private static class MinComparator implements IntegerComparator {
    @Override
    public Integer compare(Integer o1, Integer o2) {
      return o1 < o2 ? o1 : o2;
    }
  }
}
