/**
 * https://leetcode.com/problems/target-sum/
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

    public int findTargetSumWays1(int[] nums, int S) {
        return waysHelper(nums, 0, S, 0);
    }

    private int waysHelper(int[] nums, int i, int S, int curr) {
        if (i == nums.length) {
            return curr == S ? 1 : 0;
        }
        return waysHelper(nums, i + 1, S, curr - nums[i])
                + waysHelper(nums, i + 1, S, curr + nums[i]);
    }

    public int findTargetSumWays2(int[] nums, int S) {
        int N = nums.length, sum = 0;
        for (int i = 0; i < N; i++) {
            sum += nums[i];
            nums[i] += nums[i];
        }
        // reduce to a subset sum problem by magic!
        return sum < S ? 0 : subsetSum(nums, sum + S);
    }

    private int subsetSum(int[] nums, int s) {
        int N = nums.length;
        int[][] dp = new int[2][s + 1];
        dp[0][0] = 1;
        for (int i = 1; i <= N; i++) {
            for (int j = 0; j <= s; j++) {
                dp[i % 2][j] = dp[(i - 1) % 2][j] + (j < nums[i - 1] ? 0 : dp[(i - 1) % 2][j - nums[i - 1]]);
            }
        }
        return dp[N % 2][s];
    }
}
