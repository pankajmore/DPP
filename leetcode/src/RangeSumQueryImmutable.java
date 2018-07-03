/** https://leetcode.com/problems/range-sum-query-immutable/ Created by pankaj on 17/02/17. */
public class RangeSumQueryImmutable {
  public class NumArray {
    private final int[] prefixSum;

    public NumArray(int[] nums) {
      prefixSum = new int[nums.length];
      for (int i = 0; i < nums.length; i++) {
        prefixSum[i] = (i == 0 ? 0 : prefixSum[i - 1]) + nums[i];
      }
    }

    public int sumRange(int i, int j) {
      return prefixSum[j] - (i == 0 ? 0 : prefixSum[i - 1]);
    }
  }
}
