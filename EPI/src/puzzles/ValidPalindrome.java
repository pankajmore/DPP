package puzzles;

import static java.lang.Character.isLetterOrDigit;
import static java.lang.Character.toLowerCase;

/**
 * Created by Pankaj on 10/1/15.
 */
public class ValidPalindrome {
    public static boolean isPalindrome(String s) {
        int i = 0, j = s.length() - 1;
        while (i < j) {
            while (!isLetterOrDigit(s.charAt(i)) && i < j) i++;
            while (!isLetterOrDigit(s.charAt(j)) && i < j) j--;
            if (toLowerCase(s.charAt(i)) != toLowerCase(s.charAt(j))) return false;
            i++;
            j--;
        }
        return true;
    }
}
