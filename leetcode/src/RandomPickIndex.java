import java.util.Random;

/** https://leetcode.com/problems/random-pick-index/ Created by pankaj on 24/06/17. */
class RandomPickIndex {
  private int[] xs;
  private Random rng;

  RandomPickIndex(final int[] nums) {
    xs = nums;
    rng = new Random();
  }

  int pick(final int target) {
    int cnt = 0, idx = -1;
    for (int i = 0; i < xs.length; i++) {
      if (xs[i] == target) {
        cnt++;
        if (rng.nextInt(cnt) == 0) {
          idx = i;
        }
      }
    }
    return idx;
  }
}
