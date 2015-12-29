package puzzles;

import org.junit.Test;

import static puzzles.NormalizedPathnames.shortestEquivalentPath;

public class NormalizedPathnamesTest {

    @Test
    public void testShortestEquivalentPath() throws Exception {
        assert (shortestEquivalentPath("123/456").equals("123/456"));
        assert (shortestEquivalentPath("/123/456").equals("/123/456"));
        assert (shortestEquivalentPath("usr/lib/../bin/gcc").equals("usr/bin/gcc"));
        assert (shortestEquivalentPath("./../").equals(".."));
        assert (shortestEquivalentPath("../../local").equals("../../local"));
        assert (shortestEquivalentPath("./.././../local").equals("../../local"));
        assert (shortestEquivalentPath("/foo/../foo/./../").equals("/"));
        try {
            shortestEquivalentPath("/..");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        try {
            shortestEquivalentPath("/cpp_name/bin/");
        } catch (Exception e) {
            System.out.println(e.getMessage());
            assert (false);
        }
        assert (shortestEquivalentPath("scripts//./../scripts/awkscripts/././")
                .equals("scripts/awkscripts"));
    }
}