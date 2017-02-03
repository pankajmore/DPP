import java.util.Arrays;

/**
 * https://leetcode.com/problems/heaters/
 * Created by pankaj on 03/02/17.
 */
public class Heaters {
    public int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(heaters);
        if (houses.length == 0) return 0;
        int minR = 0;
        for (int x : houses) {
            int r = search(heaters, x);
            minR = Math.max(minR, r);
        }
        return minR;
    }

    private int search(int[] A, int x) {
        int lo = 0, hi = A.length - 1, idx = 0;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (A[mid] == x) return 0;
            else if (A[mid] > x) hi = mid - 1;
            else {
                idx = mid;
                lo = mid + 1;
            }
        }
        return Math.min(Math.abs(A[idx] - x), idx + 1 >= A.length ? Integer.MAX_VALUE : Math.abs(A[idx + 1] - x));
    }
}
