/** https://leetcode.com/problems/min-cost-climbing-stairs/description/ */
public class MinCostClimbingStairs {
  public int minCostClimbingStairs(int[] cost) {
    if (cost.length < 2) {
      return 0;
    }
    int[] min = new int[cost.length];
    for (int i = cost.length - 1; i >= 0; i--) {
      min[i] = cost[i];
      if (i < cost.length - 2) {
        min[i] += Math.min(min[i + 1], min[i + 2]);
      }
    }
    return Math.min(min[0], min[1]);
  }
}
