import java.util.List;

/**
 * Created by pankaj on 3/2/16.
 */
public class BooleanParenthesizing {
    private static Integer[][] trueCache, falseCache;

    /**
     * Time : O(N^3)
     * Space: O(N^2)
     *
     * @param vars list of N variables
     * @param ops  list of N - 1 operators : &, |, ^
     * @return the number of ways to evaluate the expression to true
     */
    public static int numWaysTrue(List<Boolean> vars, List<Character> ops) {
        int N = vars.size();
        trueCache = new Integer[N][N];
        falseCache = new Integer[N][N];
        return numWays(vars, ops, 0, vars.size() - 1, true);
    }

    /**
     * Time : O(N^3)
     * Space: O(N^2)
     *
     * @param vars list of N variables
     * @param ops  list of N - 1 operators : &, |, ^
     * @return the number of ways to evaluate the expression to true
     */
    public static int numWaysTrueIterative(List<Boolean> vars, List<Character> ops) {
        int N = vars.size();
        int[][] T = new int[N][N], F = new int[N][N];
        for (int i = 0; i < N; i++) {
            T[i][i] = vars.get(i) ? 1 : 0;
            F[i][i] = !vars.get(i) ? 1 : 0;
        }
        for (int gap = 1; gap < N; gap++) {
            for (int i = 0, j = gap; j < N; i++, j++) {
                T[i][j] = F[i][j] = 0;
                for (int k = i; k < j; k++) {
                    int tik = T[i][k] + F[i][k];
                    int tkj = T[k + 1][j] + F[k + 1][j];
                    if (ops.get(k) == '&') {
                        T[i][j] += T[i][k] * T[k + 1][j];
                        F[i][j] += tik * tkj - T[i][k] * T[k + 1][j];
                    } else if (ops.get(k) == '|') {
                        T[i][j] += tik * tkj - F[i][k] * F[k + 1][j];
                        F[i][j] += F[i][k] * F[k + 1][j];
                    } else {
                        T[i][j] += T[i][k] * F[k + 1][j] + F[i][k] * T[k + 1][j];
                        F[i][j] += T[i][k] * T[k + 1][j] + F[i][k] * F[k + 1][j];
                    }
                }
            }
        }
        return T[0][N - 1];
    }

    public static int numWays(List<Boolean> vars, List<Character> ops, int i, int j, boolean res) {
        if (i > j) return 0;
        if (res && trueCache[i][j] != null) return trueCache[i][j];
        if (!res && falseCache[i][j] != null) return falseCache[i][j];
        if (i == j) {
            if (res) return trueCache[i][j] = vars.get(i) == res ? 1 : 0;
            else return falseCache[i][j] = vars.get(i) == res ? 1 : 0;
        }
        int count = 0;
        for (int k = i; k < j; k++) {
            char op = ops.get(k);
            if (op == '&' && res || op == '|' && !res) {
                count += numWays(vars, ops, i, k, res) * numWays(vars, ops, k + 1, j, res);
            } else if (op == '|' && res || op == '&' && !res) {
                count += numWays(vars, ops, i, k, res) * numWays(vars, ops, k + 1, j, res)
                        + numWays(vars, ops, i, k, res) * numWays(vars, ops, k + 1, j, !res)
                        + numWays(vars, ops, i, k, !res) * numWays(vars, ops, k + 1, j, res);
            } else if (res) {
                count += numWays(vars, ops, i, k, res) * numWays(vars, ops, k + 1, j, !res)
                        + numWays(vars, ops, i, k, !res) * numWays(vars, ops, k + 1, j, res);
            } else {
                count += numWays(vars, ops, i, k, res) * numWays(vars, ops, k + 1, j, res)
                        + numWays(vars, ops, i, k, !res) * numWays(vars, ops, k + 1, j, !res);
            }
        }
        if (res) return trueCache[i][j] = count;
        else return falseCache[i][j] = count;
    }
}
