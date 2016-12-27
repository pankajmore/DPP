import sun.reflect.generics.reflectiveObjects.NotImplementedException;

/**
 * https://leetcode.com/problems/guess-number-higher-or-lower/
 * Created by pankaj on 27/12/16.
 */
public class GuessNumberHigherOrLower {
    public int guessNumber(int n) {
        int lo = 1, hi = n;
        while (lo <= hi) {
            int mid = (lo + hi) >>> 1;
            int x = guess(mid);
            if (x < 0) hi = mid - 1;
            else if (x > 0) lo = mid + 1;
            else return mid;
        }
        return -1;
    }

    private int guess(int x) {
        throw new NotImplementedException();
    }
}
