package dailycodingproblem;

/**
 * You are given an array of non-negative integers that represents a two-dimensional elevation map
 * where each element is unit-width wall and the integer is the height. Suppose it will rain and all
 * spots between two walls get filled up.
 * <p>
 * <p>Compute how many units of water remain trapped on the map in O(N) time and O(1) space.
 */
class DCP30 {
    static int trap(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }
        int len = height.length;
        int[] right = new int[len];
        right[len - 1] = height[len - 1];
        for (int i = len - 2; i >= 0; i--) {
            right[i] = Math.max(right[i + 1], height[i]);
        }
        int left = height[0];
        int sum = 0;
        for (int i = 1; i < len - 1; i++) {
            sum += Math.max(0, Math.min(left, right[i + 1]) - height[i]);
            left = Math.max(left, height[i]);
        }
        return sum;
    }
}
