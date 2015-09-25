package puzzles;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;

import static puzzles.TransformStringToOther.shortestProductionSequence;

public class TransformStringToOtherTest {

    @Test
    public void testShortestProductionSequence() throws Exception {
        assert shortestProductionSequence("", "", new HashSet<>()) == -1;
        assert shortestProductionSequence("f", "bar", new HashSet<>(Arrays.asList("f", "b", "ba", "bar"))) == -1;
        assert shortestProductionSequence("foo", "bar", new HashSet<>(Arrays.asList("foo", "boo", "bao", "bar"))) == 4;
    }
}