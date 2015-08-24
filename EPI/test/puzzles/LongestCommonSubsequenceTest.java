package puzzles;

import org.junit.Test;

public class LongestCommonSubsequenceTest {

    @Test
    public void testUsingEditDistance() {
        assert LongestCommonSubsequence.usingEditDistance("", "") == 0;
        assert LongestCommonSubsequence.usingEditDistance("", "foo") == 3;
        assert LongestCommonSubsequence.usingEditDistance("", "foo") == 3;
        assert LongestCommonSubsequence.usingEditDistance("google", "googol") == 5;
        assert LongestCommonSubsequence.usingEditDistance("xxaxbxcxx", "yayybyyc") == 3;
    }
}