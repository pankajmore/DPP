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

  public int checkRecord1(int n) {
    final int m = 1000000007;
    int[][][] dp = new int[n + 1][2][3];
    dp[0] = new int[][] {{1, 1, 1}, {1, 1, 1}};
    for (int i = 1; i <= n; i++) {
      for (int j = 0; j < 2; j++) {
        for (int k = 0; k < 3; k++) {
          int val = dp[i - 1][j][2]; // ...P
          if (j > 0) val = (val + dp[i - 1][j - 1][2]) % m; // ...A
          if (k > 0) val = (val + dp[i - 1][j][k - 1]) % m; // ...L
          dp[i][j][k] = val;
        }
      }
    }
    return dp[n][1][2];
  }

  public int checkRecord2(int n) {
    int m = 1000000007;
    int[][] A = {
      {0, 0, 1, 0, 0, 0},
      {1, 0, 1, 0, 0, 0},
      {0, 1, 1, 0, 0, 0},
      {0, 0, 1, 0, 0, 1},
      {0, 0, 1, 1, 0, 1},
      {0, 0, 1, 0, 1, 1},
    };
    return exp(A, n + 1, m)[5][2];
  }

  /* Computes A^n % m */
  private int[][] exp(int[][] A, int n, int m) {
    int s = A.length; // assume square
    int[][] I = new int[s][s];
    for (int i = 0; i < s; i++) I[i][i] = 1;
    int[][] X = I;
    while (n > 0) {
      if ((n & 1) == 1) {
        X = mult(X, A, m);
      }
      A = mult(A, A, m);
      n >>= 1;
    }
    return X;
  }

  private int[][] mult(int[][] A, int[][] B, int m) {
    int s = A.length; // == B.length
    int[][] X = new int[s][s];
    for (int i = 0; i < s; i++) {
      for (int j = 0; j < s; j++) {
        for (int k = 0; k < s; k++) {
          X[i][j] = (int) (((long) X[i][j] + (long) A[i][k] * (long) B[k][j]) % m);
        }
      }
    }
    return X;
  }
}
