import java.util.HashMap;
import java.util.Map;

/** https://leetcode.com/problems/subarray-sum-equals-k/ Created by pankaj on 03/05/17. */
class SubarraySumEqualsK {
  /**
   * @param nums array of integers
   * @param k the target sum
   * @return the number of sub arrays with sum = k
   */
  int subarraySum(final int[] nums, final int k) {
    int cnt = 0, sum = 0;
    Map<Integer, Integer> sumCnt = new HashMap<>();
    sumCnt.put(0, 1);
    for (int x : nums) {
      sum += x;
      cnt += sumCnt.getOrDefault(sum - k, 0);
      sumCnt.put(sum, sumCnt.getOrDefault(sum, 0) + 1);
    }
    return cnt;
  }
}
