/**
 * https://leetcode.com/problems/trapping-rain-water/
 * Created by pankaj on 18/02/17.
 */
public class TrappingRainWater {
    public int trap(int[] height) {
        int N = height.length;
        if (N < 3) return 0;
        int[] right = new int[N];
        for (int i = N - 1; i >= 0; i--) {
            right[i] = Math.max(i == N - 1 ? 0 : right[i + 1], height[i]);
        }
        int left = height[0];
        int water = 0;
        for (int i = 1; i < N - 1; i++) {
            water += Math.max(0, Math.min(left, right[i + 1]) - height[i]);
            left = Math.max(left, height[i]);
        }
        return water;
    }
}
