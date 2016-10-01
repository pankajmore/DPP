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

    // you need to treat n as an unsigned value
    public int popCount(int n) {
        n = (n & 0x55555555) + (n >> 1 & 0x55555555);
        n = (n & 0x33333333) + (n >> 2 & 0x33333333);
        n = (n & 0x0F0F0F0F) + (n >> 4 & 0x0F0F0F0F);
        n = (n & 0x00FF00FF) + (n >> 8 & 0x00FF00FF);
        n = (n & 0x0000FFFF) + (n >> 16 & 0x0000FFF);
        return n;
    }
}
