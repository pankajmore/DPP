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
        boolean[][] dp = new boolean[N + 1][sum + 1];
        dp[0][0] = true;
        for (int i = 1; i <= N; i++) {
            dp[i][0] = true;
            for (int j = 1; j <= sum; j++) {
                dp[i][j] = dp[i - 1][j] || (j - nums[i - 1] >= 0 && dp[i - 1][j - nums[i - 1]]);
            }
        }
        return dp[N][sum];
    }
}
