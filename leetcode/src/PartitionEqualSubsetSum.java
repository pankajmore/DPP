/**
 * https://leetcode.com/problems/partition-equal-subset-sum/
 * Created by pankaj on 10/9/16.
 */
public class PartitionEqualSubsetSum {
    public boolean canPartition(int[] nums) {
        int sum = 0, N = nums.length;
        for (int num : nums) sum += num;
        if (N == 1 || sum % 2 == 1) return false;
        sum >>>= 1;
        boolean[] dp = new boolean[sum + 1];
        dp[0] = true;
        for (int num : nums) {
            for (int j = sum; j >= num; j--) {
                dp[j] = dp[j] || dp[j - num];
            }
        }
        return dp[sum];
    }
}
