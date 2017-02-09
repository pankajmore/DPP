/**
 * https://leetcode.com/problems/third-maximum-number/
 * Created by pankaj on 09/02/17.
 */
public class ThirdMaximumNumber {
    public int thirdMax(int[] nums) {
        Integer max = null, secondMax = null, thirdMax = null;
        for (int x : nums) {
            if (max == null || x > max) max = x;
        }
        for (int x : nums) {
            if (x < max && (secondMax == null || x > secondMax)) secondMax = x;
        }
        if (secondMax == null) return max;
        for (int x : nums) {
            if (x < secondMax && (thirdMax == null || x > thirdMax)) thirdMax = x;
        }
        return thirdMax == null ? max : thirdMax;
    }
}
