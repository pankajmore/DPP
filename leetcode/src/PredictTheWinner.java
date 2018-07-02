/** https://leetcode.com/problems/predict-the-winner/ Created by pankaj on 22/01/17. */
public class PredictTheWinner {
  public boolean PredictTheWinner(int[] nums) {
    int N = nums.length;
    if (N % 2 == 0) return true;
    int esum = 0, osum = 0;
    for (int i = 0; i < N; i++) {
      if (i % 2 == 0) esum += nums[i];
      else osum += nums[i];
    }
    int f = Math.max(nums[0], nums[N - 1]);
    esum -= f;
    return f + Math.min(esum, osum) >= Math.max(esum, osum);
  }
}
