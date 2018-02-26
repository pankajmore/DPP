import java.util.Arrays;

/** https://leetcode.com/problems/coin-change/description/ */
class CoinChange {
  int coinChange(int[] coins, int amount) {
    int[] min = new int[amount + 1];
    Arrays.fill(min, -1);
    min[0] = 0;
    for (int i = 1; i <= amount; i++) {
      for (int coin : coins) {
        if (i >= coin && min[i - coin] != -1) {
          if (min[i] == -1) {
            min[i] = min[i - coin] + 1;
          } else {
            min[i] = Math.min(min[i], min[i - coin] + 1);
          }
        }
      }
    }
    return min[amount];
  }
}
