package puzzles;

/**
 * Created by Pankaj on 7/19/15.
 */
public class IntegerSquareRoot {

    /**
     * @param k k >= 0
     * @return largest integer s | s^2 <= k
     */
    public int integerSquareRoot(int k)
    {
        int l = 0, h = k, mid, s = 0;
        while(l<=h) {
            mid = l + (h-l)/2;
            if(check(mid,k)) {
                s = mid;
                l = mid+1;
            }
            else {
                h = mid-1;
            }
        }
        return s;
    }

    private boolean check(int s, int k){
        return s*s<=k;
    }
}
