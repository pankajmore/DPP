package puzzles;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static puzzles.WordBreaking.wordBreaking;

public class WordBreakingTest {

    @Test
    public void testWordBreaking() throws Exception {
        Set<String> dict = new HashSet<>(
                Arrays.asList("bed", "bath", "and", "beyond", "bat", "hand")
        );
        assert wordBreaking("bedbathandbeyond", dict).equals(
                Arrays.asList("bed", "bat", "hand", "beyond")
        );
    }
}