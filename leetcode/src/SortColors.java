/** https://leetcode.com/problems/sort-colors/ Created by pankaj on 11/04/17. */
public class SortColors {
  public void sortColors(int[] nums) {
    int N = nums.length, i = 0, j = N - 1, k = N;
    while (i <= j) {
      if (nums[j] == 1) --j;
      else if (nums[i] == 0) ++i;
      else if (nums[j] == 0) swap(nums, i, j);
      else if (nums[i] == 1) swap(nums, i, j);
      else if (nums[j] == 2) {
        --k;
        swap(nums, j, k);
        --j;
      } else if (nums[i] == 2) swap(nums, i, j);
    }
  }

  private void swap(int[] A, int i, int j) {
    int tmp = A[i];
    A[i] = A[j];
    A[j] = tmp;
  }
}