/**
 * https://leetcode.com/problems/2-keys-keyboard/
 * Created by pankaj on 02/09/17.
 */
class TwoKeysKeyboard {
  int minSteps(final int n) {
    int[] minSteps = new int[n + 1];
    for (int i = 2; i <= n; i++) {
      minSteps[i] = i;
      for (int j = 2; j <= i / 2; j++) {
        if (i % j == 0) {
          minSteps[i] = Math.min(minSteps[i], minSteps[i / j] + j);
        }
      }
    }
    return minSteps[n];
  }
}
