package com.dpp.geeksforgeeks;

import java.util.Scanner;

/**
 * http://www.practice.geeksforgeeks.org/problem-page.php?pid=153
 * Created by pankaj on 31/01/17.
 */
public class MinimumNumberOfJumps {
    public static int minJumps(int[] A) {
        int N = A.length;
        if (N == 0) return 0;
        int[] dp = new int[N];
        dp[0] = 0;
        for (int i = 1; i < N; i++) {
            dp[i] = -1;
            for (int j = 0; j < i; j++) {
                int requiredJumps = i - j;
                int canJump = A[j];
                if (dp[j] != -1 && canJump >= requiredJumps) {
                    dp[i] = dp[i] == -1 ? dp[j] + 1 : Math.min(dp[i], dp[j] + 1);
                }
            }
        }
        return dp[N - 1];
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        while (T-- > 0) {
            int N = in.nextInt();
            int[] A = new int[N];
            for (int i = 0; i < N; i++) A[i] = in.nextInt();
            System.out.println(minJumps(A));
        }
    }
}
