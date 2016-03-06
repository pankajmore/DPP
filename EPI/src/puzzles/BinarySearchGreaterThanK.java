package puzzles;

import java.util.List;

/**
 * Created by pankaj on 3/6/16.
 */
public class BinarySearchGreaterThanK {
    /**
     * Time : O(logN)
     * Space: O(1)
     *
     * @param A list of N integers
     * @param K an integer
     * @return the index of first element > K , else -1
     */
    public static int binarySearchGreaterThanK(final List<Integer> A, int K) {
        int low = 0, high = A.size() - 1, index = -1;
        while (low <= high) {
            int mid = (low + high) / 2;
            int curr = A.get(mid);
            if (curr > K) {
                index = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return index;
    }
}
