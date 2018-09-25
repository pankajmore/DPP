import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/ Created by pankaj on
 * 22/12/16.
 */
class FindAllNumbersDisappearedInAnArray {
  List<Integer> findDisappearedNumbers(int[] nums) {
    List<Integer> disappeared = new ArrayList<>();
    int N = nums.length;
    for (int i = 0; i < N; i++) {
      int idx = Math.abs(nums[i]) - 1;
      if (nums[idx] > 0) {
        nums[idx] = -nums[idx];
      }
    }
    for (int i = 0; i < N; i++) {
      if (nums[i] > 0) disappeared.add(i + 1);
    }
    return disappeared;
  }
}
