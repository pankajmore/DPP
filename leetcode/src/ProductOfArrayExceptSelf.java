/**
 * https://leetcode.com/problems/product-of-array-except-self/
 * Created by pankaj on 24/02/17.
 */
public class ProductOfArrayExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        int N = nums.length;
        int[] res = new int[N];
        res[N - 1] = 1;
        for (int i = N - 2; i >= 0; i--) res[i] = (i == N - 1 ? 1 : res[i + 1]) * nums[i + 1];
        int left = 1;
        for (int i = 0; i < N; i++) {
            res[i] *= left;
            left *= nums[i];
        }
        return res;
    }
}
