package puzzles;

/**
 * Created by pankaj on 2/12/16.
 */
public class Multiply {
    /**
     * Multiply using only bitwise and assignment operators
     *
     * @param x unsigned positive integer
     * @param y unsigned positive integer
     * @return x * y
     */
    public static int multiply(int x, int y) {
        if (x == 0 || y == 0) return 0;
        int ans = 0;
        while (y > 0) {
            if ((y & 1) == 1) ans = add(ans, x);
            x <<= 1;
            y >>= 1;
        }
        return ans;
    }

    private static int add(int x, int y) {
        int sum = 0, carry = 0;
        for (int i = 0; i < Integer.SIZE; i++) {
            int b1 = (x >> i) & 1, b2 = (y >> i) & 1;
            int bs = b1 ^ b2 ^ carry;
            sum |= (bs << i);
            carry = (b1 & b2) | (b2 & carry) | (carry & b1);
        }
        return sum;
    }
}
