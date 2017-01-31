package com.dpp.geeksforgeeks;

import java.util.Scanner;

/**
 * http://www.practice.geeksforgeeks.org/problem-page.php?pid=162
 * Created by pankaj on 31/01/17.
 */
public class EggDroppingPuzzle {
    public static int minTrials(int n, int k) {
        int[][] dp = new int[n + 1][k + 1];
        for (int i = 1; i <= n; i++) dp[i][1] = i;
        for (int j = 1; j <= k; j++) dp[1][j] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 2; j <= k; j++) {
                dp[i][j] = Integer.MAX_VALUE;
                for (int x = 1; x <= i; x++) {
                    dp[i][j] = Math.min(dp[i][j], 1 + Math.max(dp[x - 1][j - 1], dp[i - x][j]));
                }
            }
        }
        return dp[n][k];
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        while (T-- > 0) {
            int k = in.nextInt();
            int n = in.nextInt();
            System.out.println(minTrials(n, k));
        }
    }
}
