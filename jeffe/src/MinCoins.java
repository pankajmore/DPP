import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * http://jeffe.cs.illinois.edu/teaching/algorithms/notes/05-dynprog.pdf
 * Page - 18, Q1
 * Created by pankaj on 9/11/16.
 */
public class MinCoins {
    public static List<Integer> minCoins(List<Integer> coins, int k) {
        if (k < 0) return null;
        if (k == 0) return new ArrayList<>();
        else if (coins.isEmpty()) return null;
        else {
            List<Integer> x = minCoins(coins.subList(0, coins.size() - 1), k);
            List<Integer> y = minCoins(coins, k - coins.get(coins.size() - 1));
            if (y != null) {
                y.add(coins.get(coins.size() - 1));
            }
            return x == null ? y : y == null ? x : x.size() < y.size() ? x : y;
        }
    }

    public static List<Integer> minCoinsDP(List<Integer> coins, int k) {
        int[][] dp = new int[coins.size()][k + 1];
        for (int i = 0; i < coins.size(); i++) {
            for (int j = 1; j <= k; j++) {
                int x = i == 0 ? -1 : dp[i - 1][j];
                int y = j < coins.get(i) ? -1 : dp[i][j - coins.get(i)] + 1;
                dp[i][j] = x == -1 ? y : y == -1 ? x : Math.min(x, y);
            }
        }
        int minCoins = dp[coins.size() - 1][k];
        List<Integer> l = new ArrayList<>();
        int i = coins.size() - 1, j = k;
        while (i >= 0 && j >= 0) {
            int x = i == 0 ? -1 : dp[i - 1][j];
            int y = j < coins.get(i) ? -1 : dp[i][j - coins.get(i)] + 1;
            if ((x != -1 && y != -1 && y <= x) || (x == -1 && y != -1)) {
                l.add(coins.get(i));
                j -= coins.get(i);
            } else {
                i--;
            }
        }
        assert l.size() == minCoins;
        return l;
    }

    public static List<Integer> minCoinsDP1(List<Integer> coins, int k) {
        int[] dp = new int[k + 1];
        int[] choice = new int[k + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 1; i <= k; i++) {
            for (int coin : coins) {
                if (i - coin >= 0 && dp[i - coin] + 1 < dp[i]) {
                    dp[i] = dp[i - coin] + 1;
                    choice[i] = coin;
                }
            }
        }
        int minCoins = dp[k];
        List<Integer> l = new ArrayList<>();
        int i = k;
        for (int j = 0; j < minCoins; j++) {
            l.add(choice[i]);
            i -= choice[i];
        }
        Collections.reverse(l);
        assert l.size() == minCoins;
        return l;
    }

    public static List<Integer> greedy(List<Integer> coins, int k) {
        Collections.sort(coins);
        List<Integer> l = new ArrayList<>();
        while (k != 0) {
            int x = lteq(coins, k);
            if (x == -1) return Collections.emptyList();
            l.add(x);
            k -= x;
        }
        return l;
    }

    private static int lteq(List<Integer> coins, int k) {
        int lo = 0, hi = coins.size() - 1, mid, ans = -1;
        while (lo <= hi) {
            mid = lo + (hi - lo) / 2;
            if (coins.get(mid) <= k) {
                ans = coins.get(mid);
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        List<Integer> coins = Arrays.asList(1, 4, 7, 13, 28, 52, 91, 365);
        int k = 1;
        while (true) {
            List<Integer> g = greedy(coins, k);
            List<Integer> d = minCoinsDP1(coins, k);
            if (!g.equals(d)) {
                System.out.println(k);
                System.out.println(g);
                System.out.println(d);
                break;
            }
            k++;
        }
    }
}
