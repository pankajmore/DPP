import java.util.ArrayList;
import java.util.List;

/** https://leetcode.com/problems/combination-sum-iii Created by pankaj on 16/06/17. */
class CombinationSumIII {
  List<List<Integer>> combinationSum3(final int k, final int n) {
    List<Integer> curr = new ArrayList<>();
    List<List<Integer>> res = new ArrayList<>();
    combinationSum3Internal(k, n, 1, curr, res);
    return res;
  }

  private void combinationSum3Internal(
      final int k,
      final int n,
      final int start,
      final List<Integer> curr,
      final List<List<Integer>> res) {
    if (k == 0 && n == 0) {
      res.add(new ArrayList<>(curr));
    } else if (k > 0) {
      for (int i = start; i < 10 && i <= n; i++) {
        curr.add(i);
        combinationSum3Internal(k - 1, n - i, i + 1, curr, res);
        curr.remove(curr.size() - 1);
      }
    }
  }
}
