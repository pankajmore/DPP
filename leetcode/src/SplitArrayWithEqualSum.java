import java.util.HashSet;
import java.util.Set;

/** https://leetcode.com/problems/split-array-with-equal-sum/ Created by pankaj on 02/04/17. */
public class SplitArrayWithEqualSum {
  public boolean splitArray(int[] nums) {
    int N = nums.length;
    if (N < 7) return false;
    int[] sum = new int[N];
    Set<Integer> s = new HashSet<>();
    for (int i = 0; i < N; i++) sum[i] = nums[i] + (i == 0 ? 0 : sum[i - 1]);
    for (int j = 3; j < N; j++) {
      s.clear();
      for (int i = 1; i + 1 < j; i++) {
        int a = sum[i - 1], b = sum[j - 1] - sum[i];
        if (a == b) s.add(a);
      }
      for (int k = j + 1; k < N - 1; k++) {
        int c = sum[k - 1] - sum[j], d = sum[N - 1] - sum[k];
        if (c == d && s.contains(c)) return true;
      }
    }
    return false;
  }
}
