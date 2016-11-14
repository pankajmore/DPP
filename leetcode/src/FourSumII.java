import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/contest/smarking-algorithm-contest-4/problems/4sum-ii/
 * Created by pankaj on 14/11/16.
 */
public class FourSumII {
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int x : A) {
            for (int y : B) {
                map.put(x + y, map.getOrDefault(x + y, 0) + 1);
            }
        }
        int cnt = 0;
        for (int x : C) {
            for (int y : D) {
                cnt += map.getOrDefault(-x - y, 0);
            }
        }
        return cnt;
    }
}
