import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/contest/leetcode-weekly-contest-18b/problems/relative-ranks/ Created by
 * pankaj on 05/02/17.
 */
public class RelativeRanks {
  public String[] findRelativeRanks(int[] nums) {
    int N = nums.length;
    int[] A = nums.clone();
    String[] res = new String[N];
    Arrays.sort(A);
    Map<Integer, Integer> rank = new HashMap<>();
    for (int i = 0; i < N; i++) rank.put(A[i], N - i);
    for (int i = 0; i < N; i++) {
      int r = rank.get(nums[i]);
      res[i] =
          r == 1
              ? "Gold Medal"
              : r == 2 ? "Silver Medal" : r == 3 ? "Bronze Medal" : String.valueOf(r);
    }
    return res;
  }
}
