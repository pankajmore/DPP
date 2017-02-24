package puzzles;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/find-all-duplicates-in-an-array/
 * Created by pankaj on 23/02/17.
 */
public class FindAllDuplicatesInAnArray {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int x = Math.abs(nums[i]);
            if (nums[x - 1] < 0) res.add(x);
            else nums[x - 1] *= -1;
        }
        return res;
    }
}
