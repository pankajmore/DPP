package puzzles;

/**
 * Created by Pankaj on 10/13/15.
 */
public class BinarySearchCircularArray {
    public static int minIndex(Integer[] A) {
        int left = 0, right = A.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (A[mid] > A[right]) left = mid + 1;
            else right = mid;
        }
        return left;
    }
}
