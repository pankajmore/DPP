package com.dpp.geeksforgeeks;

import java.util.Scanner;

/** http://practice.geeksforgeeks.org/problem-page.php?pid=163 Created by pankaj on 30/03/17. */
public class CountOfNDigitNumbersWithGivenSum {
  public static int count(int n, int sum) {
    int M = 1000000007;
    if (n == 1) return sum > 0 && sum < 10 ? 1 : 0;
    int[][] dp = new int[n][sum + 1];
    dp[0][0] = 1;
    for (int i = 1; i < n; i++) {
      for (int j = 0; j <= sum; j++) {
        for (int d = 0; d <= 9 && j - d >= 0; d++) {
          dp[i][j] = (dp[i][j] + dp[i - 1][j - d]) % M;
        }
      }
    }
    int cnt = 0;
    for (int d = 1; d <= 9 && sum - d >= 0; d++) {
      cnt = (cnt + dp[n - 1][sum - d]) % M;
    }
    return cnt == 0 ? -1 : cnt;
  }

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int T = in.nextInt();
    while (T-- > 0) {
      int n = in.nextInt();
      int sum = in.nextInt();
      System.out.println(count(n, sum));
    }
  }
}
