package puzzles;

import org.junit.Test;

import static puzzles.CanStringBePalindromeHash.canStringBeAPalindrome;

public class CanStringBePalindromeHashTest {

  @Test
  public void testCanStringBeAPalindrome() throws Exception {
    assert canStringBeAPalindrome("");
    assert canStringBeAPalindrome("a");
    assert canStringBeAPalindrome("aa");
    assert canStringBeAPalindrome("aab");
    assert canStringBeAPalindrome("itinn");
    assert canStringBeAPalindrome("edified");
  }
}
