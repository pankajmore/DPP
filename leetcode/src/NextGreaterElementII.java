import java.util.Stack;

/**
 * https://leetcode.com/contest/leetcode-weekly-contest-18b/problems/next-greater-element-ii/
 * Created by pankaj on 06/02/17.
 */
public class NextGreaterElementII {
  public int[] nextGreaterElements(int[] nums) {
    int N = nums.length;
    int[] res = new int[N];
    if (N == 0) return res;
    int max = nums[0], idx = 0;
    for (int i = 1; i < N; i++) {
      if (nums[i] > max) {
        max = nums[i];
        idx = i;
      }
    }
    Stack<Integer> s = new Stack<>();
    int i = idx;
    for (int ignored : nums) {
      while (!s.isEmpty() && nums[i] >= s.peek()) s.pop();
      res[i] = s.isEmpty() ? -1 : s.peek();
      s.push(nums[i]);
      i = Math.floorMod(i - 1, N);
    }
    return res;
  }
}
