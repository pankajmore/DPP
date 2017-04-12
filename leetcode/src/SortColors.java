/** https://leetcode.com/problems/sort-colors/ Created by pankaj on 11/04/17. */
public class SortColors {
  public void sortColors(int[] nums) {
    int N = nums.length, i = 0, j = 0, k = N - 1;
    while (j <= k) {
      if (nums[j] == 0) {
        swap(nums, i, j);
        i = i + 1;
        j = j + 1;
      } else if (nums[j] == 2) {
        swap(nums, j, k);
        k = k - 1;
      } else {
        j = j + 1;
      }
    }
  }

  private void swap(int[] A, int i, int j) {
    int tmp = A[i];
    A[i] = A[j];
    A[j] = tmp;
  }
}