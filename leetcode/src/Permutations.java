import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/** https://leetcode.com/problems/permutations/ Created by pankaj on 23/06/17. */
class Permutations {
  List<List<Integer>> permute(final int[] nums) {
    List<List<Integer>> permutations = new ArrayList<>();
    List<Integer> permutation = new ArrayList<>();
    for (int num : nums) {
      permutation.add(num);
    }
    permuteInternal(permutations, permutation, 0);
    return permutations;
  }

  private void permuteInternal(
      final List<List<Integer>> permutations, final List<Integer> permutation, final int start) {
    if (start == permutation.size()) {
      permutations.add(new ArrayList<>(permutation));
    } else {
      for (int i = start; i < permutation.size(); i++) {
        Collections.swap(permutation, i, start);
        permuteInternal(permutations, permutation, start + 1);
        Collections.swap(permutation, i, start);
      }
    }
  }
}
