package puzzles;

import org.junit.Test;

import static org.junit.Assert.*;
import static puzzles.RegularExpression.isMatch;

public class RegularExpressionTest {

    @Test
    public void testIsMatch() throws Exception {
        assert (isMatch(".", "a"));
        assert (isMatch("a", "a"));
        assert (!isMatch("a", "b"));
        assert (isMatch("a.9", "aW9"));
        assert (!isMatch("a.9", "aW19"));
        assert (isMatch("^a.9", "aW9"));
        assert (!isMatch("^a.9", "baW19"));
        assert (isMatch(".*", "a"));
        assert (isMatch(".*", ""));
        assert (isMatch("c*", "c"));
        assert (!isMatch("aa*", "c"));
        assert (isMatch("ca*", "c"));
        assert (isMatch(".*", "asdsdsa"));
        assert (isMatch("9$", "xxxxW19"));

        assert (isMatch(".*a", "ba"));

        assert (isMatch(".*a", "ba"));
        assert (isMatch("^a.*9$", "axxxxW19"));

        assert (isMatch("^a.*W19$", "axxxxW19"));
        assert (isMatch(".*a.*W19", "axxxxW19123"));
        assert (!isMatch(".*b.*W19", "axxxxW19123"));
        assert (isMatch("n.*", "n"));
        assert (isMatch("a*n.*", "an"));
        assert (isMatch("a*n.*", "ana"));
        assert (isMatch("a*n.*W19", "anaxxxxW19123"));
        assert (isMatch(".*a*n.*W19", "asdaaadnanaxxxxW19123"));
        assert (isMatch(".*.*.a*n.*W19", "asdaaadnanaxxxxW19123"));
    }
}