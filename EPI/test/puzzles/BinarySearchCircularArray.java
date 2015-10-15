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

    public static int minIndexWithDuplicatesAllowed(Integer[] A) {
        return minIndexWithDuplicatesAllowedHelper(A, 0, A.length - 1);
    }

    private static int minIndexWithDuplicatesAllowedHelper(Integer[] A, int l, int r) {
        if (l == r) return l;
        int mid = l + (r - l) / 2;
        if (A[mid] > A[r]) return minIndexWithDuplicatesAllowedHelper(A, mid + 1, r);
        else if (A[mid] < A[r]) return minIndexWithDuplicatesAllowedHelper(A, l, mid);
        else {
            int l_res = minIndexWithDuplicatesAllowedHelper(A, l, mid);
            int r_res = minIndexWithDuplicatesAllowedHelper(A, mid + 1, r);
            return A[r_res] < A[l_res] ? r_res : l_res;
        }
    }

    public static int index(Integer[] A, Integer x) {
        int l = 0, r = A.length - 1, m = minIndex(A);
        if (x < A[r]) l = m;
        else if (x > A[r]) r = m;
        else return r;
        while (l <= r) {
            m = l + (r - l) / 2;
            if (x > A[m]) l = m + 1;
            else if (x < A[m]) r = m - 1;
            else return m;
        }
        return -1;
    }
}
