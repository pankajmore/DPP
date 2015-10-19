package puzzles;

import org.junit.Test;

import java.util.Map;

import static org.junit.Assert.*;
import static puzzles.CountOccurrencesInSentence.countOccurrences;

public class CountOccurrencesInSentenceTest {

    @Test
    public void testCountOccurrences() throws Exception {
        Map<Character, Integer> charToCount = countOccurrences("foo bar! ABA A");
        assert (charToCount.get('f') == 1);
        assert (charToCount.get('F') == null);
        assert (charToCount.get('o') == 2);
        assert (charToCount.get('x') == null);
        assert (charToCount.get(' ') == 3);
        assert (charToCount.get('!') == 1);
        assert (charToCount.get('A') == 3);
        assert (charToCount.get('B') == 1);
    }
}