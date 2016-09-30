/**
 * https://leetcode.com/problems/number-of-1-bits/
 * Created by pankaj on 9/30/16.
 */
public class NumberOf1Bits {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int c = 0;
        while (n != 0) {
            n &= n - 1;
            c++;
        }
        return c;
    }
}
