/**
 * https://leetcode.com/problems/majority-element/
 * Created by pankaj on 17/12/16.
 */
public class MajorityElement {
    public int majorityElement(int[] nums) {
        int majority = nums[0];
        int cnt = 0;
        for (int x : nums) {
            if (cnt == 0) majority = x;
            cnt = majority == x ? cnt + 1 : cnt - 1;
        }
        return majority;
    }
}
