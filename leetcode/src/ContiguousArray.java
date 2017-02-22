import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/contiguous-array/
 * Created by pankaj on 22/02/17.
 */
public class ContiguousArray {
    public int findMaxLength(int[] nums) {
        int N = nums.length;
        int[] A = new int[N];
        int max = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        for (int i = 0; i < N; i++) {
            A[i] = (i == 0 ? 0 : A[i - 1]) + (nums[i] == 0 ? -1 : 1);
            map.put(A[i], map.getOrDefault(A[i], i));
            max = Math.max(max, i - map.get(A[i]));
        }
        return max;
    }
}
