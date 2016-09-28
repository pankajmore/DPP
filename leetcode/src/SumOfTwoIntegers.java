/**
 * https://leetcode.com/problems/sum-of-two-integers/
 * Created by pankaj on 9/28/16.
 */
public class SumOfTwoIntegers {
    public int getSum(int a, int b) {
        int sum = 0;
        int carry = 0;
        for (int i = 0; i < 32; i++) {
            int x = a & 1;
            int y = b & 1;
            int d = x ^ y ^ carry;
            carry = ((x == 1 && y == 1) || (x == 1 && carry == 1) || (y == 1 && carry == 1)) ? 1 : 0;
            sum = sum | (d << i);
            a >>= 1;
            b >>= 1;
        }
        return sum;
    }
}
