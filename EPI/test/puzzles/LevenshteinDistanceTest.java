package puzzles;

import org.junit.Test;

import static puzzles.LevenshteinDistance.editDistance;

public class LevenshteinDistanceTest {

    @Test
    public void testEditDistance() throws Exception {
        assert editDistance("", "") == 0;
        assert editDistance("", "foo") == 3;
        assert editDistance("foo", "") == 3;
        assert editDistance("foo", "foo") == 0;
        assert editDistance("google", "googol") == 2;

    }
}