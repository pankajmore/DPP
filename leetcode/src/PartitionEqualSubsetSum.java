import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

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

    public boolean canPartition1(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        if (sum % 2 == 1) return false;
        Set<Integer> visited = new HashSet<>();
        visited.add(0);
        Arrays.stream(nums).forEach((n) -> new ArrayList<>(visited).stream().forEach((s) -> visited.add(s + n)));
        return visited.contains(sum / 2);
    }
}
