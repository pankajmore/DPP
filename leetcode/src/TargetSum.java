/**
 * https://leetcode.com/contest/leetcode-weekly-contest-16a/problems/target-sum/
 * Created by pankaj on 21/01/17.
 */
public class TargetSum {
    public int findTargetSumWays(int[] nums, int S) {
        int N = nums.length, max = 0;
        if (N == 0) return 1;
        for (int x : nums) max += x;
        if (S > max || S < -max) return 0;
        int[][] dp = new int[N][2 * max + 1];
        dp[0][max + nums[0]] += 1;
        dp[0][max - nums[0]] += 1;
        for (int i = 1; i < N; i++) {
            for (int j = -max; j <= max; j++) {
                dp[i][j + max] = (j - nums[i] + max < 0 ? 0 : dp[i - 1][j - nums[i] + max]) +
                        (j + nums[i] + max > 2 * max ? 0 : dp[i - 1][j + nums[i] + max]);
            }
        }
        return dp[N - 1][S + max];
    }
}
