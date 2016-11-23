package dp;

import com.sun.istack.internal.NotNull;

import java.util.List;

import static dp.Q14.Move.*;

/**
 * http://jeffe.cs.illinois.edu/teaching/algorithms/notes/05-dynprog.pdf
 * Page - 23, Q14
 * Created by pankaj on 22/11/16.
 */
public class Q14 {
    public static int maxScore(@NotNull List<Move> moves) {
        int N = moves.size();
        if (N == 0) return 0;
        final Move[] m = Move.values();
        int[][] dp = new int[N][m.length];
        int max = 0;
        dp[0][0] = moves.get(0) == LEFT ? -1 : moves.get(0) == RIGHT ? 1 : 0;
        dp[0][1] = moves.get(0) == RIGHT ? -1 : moves.get(0) == LEFT ? 1 : 0;
        dp[0][2] = moves.get(0) == UP || moves.get(0) == DOWN ? -1 : 0;
        dp[0][3] = moves.get(0) == UP || moves.get(0) == DOWN ? -1 : 0;
        max = Math.max(max, Math.max(dp[0][0], dp[0][1]));
        for (int i = 1; i < N; i++) {
            for (int j = 0; j < m.length; j++) {
                int c1 = moves.get(i).ordinal(), c2 = j;
                if (c1 == c2) dp[i][j] = -1;
                else {
                    int p1 = moves.get(i - 1).ordinal(), p2;
                    for (int k = 0; k < m.length; k++) {
                        p2 = k;
                        if (dp[i - 1][k] != -1) {
                            if ((c1 == p1 && c2 == p2) || (c1 == p2 && c2 == p1))
                                dp[i][j] = Math.max(dp[i][j], dp[i - 1][k] + 1);
                            else if (c1 == p1 || c1 == p2 || c2 == p1 || c2 == p2)
                                dp[i][j] = Math.max(dp[i][j], dp[i - 1][k]);
                        }
                    }
                }
                max = Math.max(max, dp[i][j]);
            }
        }
        return max;
    }

    public static int maxScoreSlow(@NotNull List<Move> moves) {
        int N = moves.size();
        if (N == 0) return 0;
        int max = 0;
        for (int s = 0; s < 1 << N; s++) {
            max = Math.max(max, score(moves, s));
        }
        return max;
    }

    private static int score(List<Move> moves, int s) {
        Move x = LEFT, y = RIGHT;
        int cnt = 0;
        for (Move m : moves) {
            if (x == m || y == m) cnt++;
            else {
                boolean choice = (s & 1) == 0;
                s >>= 1;
                if (choice) x = m;
                else y = m;
            }
        }
        return cnt;
    }

    public enum Move {
        LEFT,
        RIGHT,
        UP,
        DOWN
    }
}
