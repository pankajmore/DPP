package puzzles;

import java.util.List;

/**
 * Created by pankaj on 1/23/16.
 */
public class ArrayEndReachable {
    /**
     * Time : O(N)
     * Space : O(1)
     *
     * @param A A[i] indicates how far can we jump from i
     * @return true if we can reach last index from start
     */
    public static boolean isArrayEndReachable(List<Integer> A) {
        int N = A.size();
        int lastReachableIndex = N - 1;
        for (int i = N - 2; i >= 0; i--) {
            if (lastReachableIndex - i <= A.get(i)) lastReachableIndex = i;
        }
        return lastReachableIndex == 0;
    }
}
