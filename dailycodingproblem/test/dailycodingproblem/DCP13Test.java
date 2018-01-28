package dailycodingproblem;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static dailycodingproblem.DCP13.longestSubstringKDistinct;

class DCP13Test {

    @Test
    void longestSubstringKDistinctTest() {
        Assertions.assertEquals(1, longestSubstringKDistinct("abc", 1));
        Assertions.assertEquals(2, longestSubstringKDistinct("aac", 1));
        Assertions.assertEquals(2, longestSubstringKDistinct("caa", 1));
        Assertions.assertEquals(3, longestSubstringKDistinct("aba", 2));
        Assertions.assertEquals(4, longestSubstringKDistinct("aabbc", 2));
        Assertions.assertEquals(4, longestSubstringKDistinct("ababc", 2));
    }
}