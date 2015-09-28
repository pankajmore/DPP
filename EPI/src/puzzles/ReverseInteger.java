package puzzles;

/**
 * Created by Pankaj on 9/28/15.
 */
public class ReverseInteger {
    public static int reverse(int x) {
        boolean negative = false;
        if (x < 0) {
            negative = true;
            x = -x;
        }
        int r = 0, rem = 0;
        while (x > 0) {
            rem = x % 10;
            x /= 10;
            r = r * 10 + rem;
        }
        return negative ? -r : r;
    }

    public static int reverseUsingString(int x) {
        boolean negative = false;
        if (x < 0) {
            negative = true;
            x = -x;
        }
        String s = ((Integer) x).toString();
        String r = new StringBuilder(s).reverse().toString();
        int res = Integer.parseInt(r);
        return negative ? -res : res;
    }
}
