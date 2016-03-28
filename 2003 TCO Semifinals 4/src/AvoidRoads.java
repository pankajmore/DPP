public class AvoidRoads {

    public long numWays(int N, int M, String[] bad) {
        long[][] dp = new long[M + 1][N + 1];
        boolean[][] right = new boolean[M + 1][N + 1], down = new boolean[M + 1][N + 1];
        for (String s : bad) {
            String[] split = s.split(" ");
            int x1 = Integer.parseInt(split[0]), y1 = Integer.parseInt(split[1]);
            int x2 = Integer.parseInt(split[2]), y2 = Integer.parseInt(split[3]);
            if (x1 == x2) down[Math.max(y1, y2)][x1] = true;
            else right[y1][Math.max(x1, x2)] = true;
        }

        dp[0][0] = 1;
        for (int i = 0; i <= M; i++) {
            for (int j = 0; j <= N; j++) {
                dp[i][j] += (i >= 1 && !down[i][j] ? dp[i - 1][j] : 0)
                        + (j >= 1 && !right[i][j] ? dp[i][j - 1] : 0);
            }
        }
        return dp[M][N];
    }
}
