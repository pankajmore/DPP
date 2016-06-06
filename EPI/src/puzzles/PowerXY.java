package puzzles;

/**
 * Created by pankajm on 5/6/15.
 */
// TODO: Check for overflows
public class PowerXY {
    public static double recPow(double x, long y) {
        if (y < 0) return 1 / recPow(x, -y);
        if (y == 0) return 1;
        double temp = recPow(x, y / 2);
        if (y % 2 == 0) {
            return temp * temp;
        } else {
            return x * temp * temp;
        }
    }

    public static long recPow(long a, long n, long m) {
        if (n < 0) throw new IllegalArgumentException("Negative Exponent: " + n);
        if (m <= 0) throw new IllegalArgumentException("Non-positive modulus: " + m);
        if (n == 0) return 1 % m;
        long temp = recPow(a, n >>> 1, m);
        if ((n & 1) == 0) return (temp * temp) % m;
        else return (a * (temp * temp) % m) % m;
    }

    public static double iterPow(double x, long y) {
        if (y < 0) return 1 / iterPow(x, -y);
        double res = 1;
        while (y > 0) {
            if ((y & 1) == 1)
                res *= x;
            x *= x;
            y >>>= 1;
        }
        return res;
    }

    public static long iterPow(long a, long n, long m) {
        if (n < 0) throw new IllegalArgumentException("Negative Exponent: " + n);
        if (m <= 0) throw new IllegalArgumentException("Non-positive modulus: " + m);
        long res = 1;
        while (n > 0) {
            if ((n & 1) == 1)
                res = (res * a) % m;
            a = (a * a) % m;
            n >>>= 1;
        }
        return res % m;
    }
}
