/**
 * https://leetcode.com/problems/product-of-array-except-self/
 * Created by pankaj on 24/02/17.
 */
public class ProductOfArrayExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        int N = nums.length;
        int[] res = new int[N];
        for (int i = 0, left = 1; i < N; i++) {
            res[i] = left;
            left *= nums[i];
        }
        for (int i = N - 1, right = 1; i >= 0; i--) {
            res[i] *= right;
            right *= nums[i];
        }
        return res;
    }
}
