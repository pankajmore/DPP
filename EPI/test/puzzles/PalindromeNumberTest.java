package puzzles;

import org.junit.Test;

import static org.junit.Assert.*;
import static puzzles.PalindromeNumber.isPalindrome;

public class PalindromeNumberTest {

    @Test
    public void testIsPalindrome() throws Exception {
        assert !isPalindrome(-1);
        assert isPalindrome(0);
        assert isPalindrome(9);
        assert isPalindrome(121);
        assert isPalindrome(123321);
        assert !isPalindrome(123421);
    }
}