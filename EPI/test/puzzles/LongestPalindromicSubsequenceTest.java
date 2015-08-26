package puzzles;

import org.junit.Test;

public class LongestPalindromicSubsequenceTest {

    @Test
    public void testMinDeletes() {
        assert LongestPalindromicSubsequence.minDeletes("") == 0;
        assert LongestPalindromicSubsequence.minDeletes("nitin") == 0;
        assert LongestPalindromicSubsequence.minDeletes("aba") == 0;
        assert LongestPalindromicSubsequence.minDeletes("ab") == 1;
        assert LongestPalindromicSubsequence.minDeletes("anitin") == 1;
        assert LongestPalindromicSubsequence.minDeletes("nitina") == 1;
        assert LongestPalindromicSubsequence.minDeletes("12n34i567ti8n9") == 9;
    }
}