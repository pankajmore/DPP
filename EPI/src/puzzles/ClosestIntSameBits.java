package puzzles;

/**
 * Created by pankaj on 3/26/16.
 */
public class ClosestIntSameBits {
    /**
     * Time : O(1) : a constant number of bitwise ops independent of word size
     * Space: O(Integer.SIZE)
     *
     * @param x an un-signed integer
     * @return the closes int with same number of 1's and 0's as x
     */
    public static int closestIntSameBits(int x) {
        int n = (x & 1) == 1 ? ~x : x, y = n & ~(n - 1);
        y -= y >> 1;
        return (x & 1) == 0 ? x - y : x + y;
    }

    /**
     * Time : O(Integer.SIZE)
     * Space: O(Integer.SIZE)
     *
     * @param x unsigned integer
     * @return closest integer with same number of 1's and 0's
     * @throws Exception
     */
    public static int closestIntSameBits1(int x) throws Exception {
        for (int i = 0; i < Integer.SIZE - 1; i++) {
            if (((x >> i) & 1) != ((x >> (i + 1)) & 1)) {
                return x ^ ((1 << i) | (1 << (i + 1)));
            }
        }
        throw new Exception("All bits same in " + x);
    }

    public static int closestIntSameBitsBruteForce(int x) {
        int ones = cntOnes(x);
        int i = 1;
        while (true) {
            if (cntOnes(x - i) == ones) return x - i;
            if (cntOnes(x + i) == ones) return x + i;
            i++;
        }
    }

    private static int cntOnes(int x) {
        int c = 0;
        while (x > 0) {
            x = x & (x - 1);
            c++;
        }
        return c;
    }
}
