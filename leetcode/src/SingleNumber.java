/**
 * https://leetcode.com/problems/single-number/
 * Created by pankaj on 10/4/16.
 */
public class SingleNumber {
    public int singleNumber(int[] nums) {
        int x = 0;
        for (int n : nums) x ^= n;
        return x;
    }
}
