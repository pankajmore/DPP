/** https://leetcode.com/problems/student-attendance-record-ii/ Created by pankaj on 19/04/17. */
public class StudentAttendanceRecordII {
  public int checkRecord(int n) {
    long[] dp = new long[Math.max(4, n + 1)];
    long P = 1000000007L;
    dp[0] = 1L;
    dp[1] = 2L;
    dp[2] = 4L;
    dp[3] = 7L;
    for (int i = 4; i <= n; i++) {
      dp[i] = (2 * (dp[i - 2] + dp[i - 3]) + dp[i - 4]) % P;
    }
    long cnt = dp[n];
    for (int i = 0; i < n; i++) {
      cnt = (cnt + dp[i] * dp[n - 1 - i]) % P;
    }
    return (int) cnt;
  }
}
