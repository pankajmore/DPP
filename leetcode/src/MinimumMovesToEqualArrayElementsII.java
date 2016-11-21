import java.util.Arrays;

/**
 * https://leetcode.com/problems/minimum-moves-to-equal-array-elements-ii/
 * Created by pankaj on 21/11/16.
 */
public class MinimumMovesToEqualArrayElementsII {
    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        int N = nums.length;
        if (N == 0) return 0;
        int mid = nums[N / 2];
        int cnt = 0;
        for (int num : nums) cnt += Math.abs(mid - num);
        return cnt;
    }
}
