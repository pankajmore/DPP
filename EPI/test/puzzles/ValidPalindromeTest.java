package puzzles;

import org.junit.Test;

import static puzzles.ValidPalindrome.isPalindrome;

public class ValidPalindromeTest {

  @Test
  public void testIsPalindrome() throws Exception {
    assert isPalindrome("");
    assert isPalindrome("a");
    assert !isPalindrome("ab");
    assert isPalindrome("^a*ba!;");

    assert (isPalindrome("A man, a plan, a canal: Panama"));
    assert (!isPalindrome("race a car"));
    assert (isPalindrome("Able was I, ere I saw Elba!"));
    assert (!isPalindrome("Ray a Ray"));
  }
}
