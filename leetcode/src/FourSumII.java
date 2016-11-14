import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/contest/smarking-algorithm-contest-4/problems/4sum-ii/
 * Created by pankaj on 14/11/16.
 */
public class FourSumII {
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        int N = A.length;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                map.put(A[i] + B[j], map.getOrDefault(A[i] + B[j], 0) + 1);
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
