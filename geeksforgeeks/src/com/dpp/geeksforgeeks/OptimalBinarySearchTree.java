package com.dpp.geeksforgeeks;

/**
 * Time : O(N^3)
 * Space: O(N^2)
 * http://www.geeksforgeeks.org/dynamic-programming-set-24-optimal-binary-search-tree/
 * Created by pankaj on 01/03/17.
 */
public class OptimalBinarySearchTree {
    public static int optimalSearchTree(int[] freq) {
        int N = freq.length;
        int[] sum = new int[N];
        for (int i = 0; i < N; i++) sum[i] = (i == 0 ? 0 : sum[i - 1]) + freq[i];
        int[][] dp = new int[N][N];
        for (int i = N - 1; i >= 0; i--) {
            for (int j = i; j < N; j++) {
                dp[i][j] = Integer.MAX_VALUE;
                int currentSum = sum[j] - (i == 0 ? 0 : sum[i - 1]);
                for (int k = i; k <= j; k++) {
                    dp[i][j] = Math.min(dp[i][j],
                            currentSum + (i == k ? 0 : dp[i][k - 1]) + (j == k ? 0 : dp[k + 1][j]));
                }
            }
        }
        return dp[0][N - 1];
    }
}
