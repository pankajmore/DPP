import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/lexicographical-numbers/
 * Created by pankaj on 8/22/16.
 */
public class LexicographicalNumbers {
    public List<Integer> lexicalOrder(int n) {
        List<Integer> A = new ArrayList<>();
        dfs(0, n, A);
        return A;
    }

    private void dfs(int curr, int n, List<Integer> A) {
        for (int i = 0; i <= 9; i++) {
            int x = curr * 10 + i;
            if (x == 0) continue;
            if (x > n) return;
            A.add(x);
            dfs(x, n, A);
        }
    }
}
