/** Created by pankaj on 29/05/17. */
class MaximumXorOfTwoNumbersInAnArray {
  int findMaximumXOR(final int[] nums) {
    int max = 0;
    for (int x : nums) {
      for (int y : nums) {
        max = Math.max(max, x ^ y);
      }
    }
    return max;
  }
}
