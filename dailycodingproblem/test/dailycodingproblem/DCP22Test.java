package dailycodingproblem;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static dailycodingproblem.DCP22.wordBreak;
import static org.junit.jupiter.api.Assertions.assertEquals;

class DCP22Test {

    @Test
    void wordBreakTest() {
        assertEquals(null, wordBreak("foobar", Arrays.asList("foo", "obar")));
        assertEquals(
                Arrays.asList("the", "quick", "brown", "fox"),
                wordBreak("thequickbrownfox", Arrays.asList("quick", "brown", "the", "fox")));
        assertEquals(
                Arrays.asList("bedbath", "and", "beyond"),
                wordBreak("bedbathandbeyond", Arrays.asList("bed", "bath", "bedbath", "and", "beyond")));
    }
}
