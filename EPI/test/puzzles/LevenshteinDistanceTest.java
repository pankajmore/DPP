package puzzles;

import org.junit.Test;

import static puzzles.LevenshteinDistance.editDistance;
import static puzzles.LevenshteinDistance.editDistanceDP;

public class LevenshteinDistanceTest {

    @Test
    public void testEditDistance() throws Exception {
        assert editDistance("", "") == 0;
        assert editDistance("", "foo") == 3;
        assert editDistance("foo", "") == 3;
        assert editDistance("foo", "foo") == 0;
        assert editDistanceDP("goo", "google") == 3;
        assert editDistance("google", "googol") == 2;
    }

    @Test
    public void testEditDistanceDP() throws Exception {
        assert editDistanceDP("", "") == 0;
        assert editDistanceDP("", "foo") == 3;
        assert editDistanceDP("foo", "") == 3;
        assert editDistanceDP("foo", "foo") == 0;
        assert editDistanceDP("goo", "google") == 3;
        assert editDistanceDP("google", "googol") == 2;
    }
}