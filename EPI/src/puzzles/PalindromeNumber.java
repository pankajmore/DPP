package puzzles;

/**
 * Created by Pankaj on 12/20/15.
 */
public class PalindromeNumber {
    public static boolean isPalindrome(int x) {
        if (x < 0) return false;
        if (x == 0) return true;
        int NUM_DIGITS = (int) (Math.floor(Math.log10(x))) + 1;
        int msdMask = (int) Math.pow(10, NUM_DIGITS - 1);

        for (int i = 0; i < NUM_DIGITS / 2; i++) {
            if (x / msdMask != x % 10) return false;
            x %= msdMask;
            x /= 10;
            msdMask /= 100;
        }
        return true;
    }
}
