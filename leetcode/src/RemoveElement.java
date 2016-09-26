/**
 * https://leetcode.com/problems/remove-element/
 * Created by pankaj on 9/26/16.
 */
public class RemoveElement {
    public int removeElement(int[] nums, int val) {
        int i = 0, j = 0, N = nums.length;
        while (i < N && j < N) {
            if (nums[j] == val) j++;
            else {
                nums[i] = nums[j];
                i++;
                j++;
            }
        }
        return i;
    }
}
