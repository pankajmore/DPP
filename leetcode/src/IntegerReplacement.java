/**
 * https://leetcode.com/problems/integer-replacement/
 * Created by pankaj on 9/14/16.
 */
public class IntegerReplacement {
    public int integerReplacement(int n_) {
        long n = (long) n_;
        int res = 0;
        while (n > 1) {
            if (n % 2 == 0) n /= 2;
            else if (n == 3) n -= 1;
            else if (Long.numberOfTrailingZeros(n + 1) > Long.numberOfTrailingZeros(n - 1)) n += 1;
            else n -= 1;
            res++;
        }
        return res;
    }
}
