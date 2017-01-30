/**
 * https://leetcode.com/problems/missing-number/
 * Created by pankaj on 30/01/17.
 */
public class MissingNumber {
    public int missingNumber(int[] nums) {
        int i = 0, missing = nums.length;
        for (int x : nums) {
            missing ^= x ^ i++;
        }
        return missing;
    }
}
