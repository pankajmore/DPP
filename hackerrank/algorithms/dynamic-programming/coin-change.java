/* https://www.hackerrank.com/challenges/coin-change */
import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int M = in.nextInt();
        int[] coins = new int[M];
        for(int i = 0; i < M; i++) coins[i] = in.nextInt();

        long[][] dp = new long[N + 1][M + 1];
        for(int j = 0; j <= M; j++) dp[0][j] = 1L;
        for(int i = 1; i <= N; i++) dp[i][0] = 0L;
        for(int i = 1; i <= N; i++) {
            for(int j = 1; j <= M; j++) {
                dp[i][j] = dp[i][j - 1] + (i >= coins[j - 1] ? dp[i - coins[j - 1]][j] : 0L);
            }
        }
        System.out.println(dp[N][M]);
    }
}