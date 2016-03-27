public class BadNeighbors {

    public int maxDonations(int[] donations) {
        int best = 0, N = donations.length;
        int[] dp = new int[N];
        dp[0] = donations[0];
        for (int i = 1; i < N - 1; i++) {
            dp[i] = Math.max(donations[i] + (i >= 2 ? dp[i - 2] : 0), dp[i - 1]);
            best = Math.max(best, dp[i]);
        }
        dp[0] = 0;
        for (int i = 1; i < N; i++) {
            dp[i] = Math.max(donations[i] + (i >= 2 ? dp[i - 2] : 0), dp[i - 1]);
            best = Math.max(best, dp[i]);
        }
        return best;
    }
}
