/** https://leetcode.com/problems/sort-colors/ Created by pankaj on 11/04/17. */
public class SortColors {
  public void sortColors(int[] nums) {
    int[] cnt = new int[3];
    for (int x : nums) cnt[x]++;
    for (int idx = 0, i = 0; i < 3; i++) {
      while (cnt[i]-- > 0) nums[idx++] = i;
    }
  }
}