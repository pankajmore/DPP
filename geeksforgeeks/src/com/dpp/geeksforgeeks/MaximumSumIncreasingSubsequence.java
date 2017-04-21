package com.dpp.geeksforgeeks;

import java.util.Scanner;

/**
 * http://practice.geeksforgeeks.org/problems/maximum-sum-increasing-subsequence/0 Created by pankaj
 * on 21/04/17.
 */
public class MaximumSumIncreasingSubsequence {
  public static int maximumSumIncreasingSubsequence(int[] A) {
    int N = A.length, max = 0;
    int[] dp = new int[N];
    for (int i = 0; i < N; i++) {
      dp[i] = A[i];
      for (int j = 0; j < i; j++) {
        if (A[j] < A[i]) {
          dp[i] = Math.max(dp[i], dp[j] + A[i]);
        }
      }
      max = Math.max(max, dp[i]);
    }
    return max;
  }

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int T = in.nextInt();
    while (T-- > 0) {
      int N = in.nextInt();
      int[] A = new int[N];
      for (int i = 0; i < N; i++) A[i] = in.nextInt();
      System.out.println(maximumSumIncreasingSubsequence(A));
    }
  }
}
