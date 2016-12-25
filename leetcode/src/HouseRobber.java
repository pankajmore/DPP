/**
 * https://leetcode.com/problems/house-robber/
 * Created by pankaj on 25/12/16.
 */
public class HouseRobber {
    public int rob(int[] nums) {
        int N = nums.length;
        int a = 0, b = 0;
        for (int i = 0; i < N; i++) {
            int tmp = Math.max(b, a + nums[i]);
            a = b;
            b = tmp;
        }
        return b;
    }
}
