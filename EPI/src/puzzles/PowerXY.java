package puzzles;

/**
 * Created by pankajm on 5/6/15.
 */
public class PowerXY {
    public static double recPow(double x, long y) {
        if (y == 0) return 1;
        if (y % 2 == 0) {
            return recPow(x * x, y / 2);
        } else {
            return x * recPow(x * x, y / 2);
        }
    }

    public static double iterPow(double x, long y) {
        double res = 1;
        while (y > 0) {
            if ((y & 1) == 1)
                res *= x;
            x *= x;
            y >>>= 1;
        }
        return res;
    }
}
