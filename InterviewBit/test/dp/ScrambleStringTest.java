import org.junit.Test;

/**
 * Created by pankaj on 3/7/16.
 */
public class ScrambleStringTest {

    @Test
    public void testScrambled() throws Exception {
        assert ScrambleString.scrambled("gr", "rg");
        assert ScrambleString.scrambled("great", "rgtae");
        assert ScrambleString.scrambled("great", "grtae");
        assert ScrambleString.scrambled("great", "great");
        assert ScrambleString.scrambled("great", "tearg");
        assert ScrambleString.scrambled("great", "tgrea");

        assert ScrambleString.scrambled("xstjzkfpkggnhjzkpfjoguxvkbuopi", "xbouipkvxugojfpkzjhnggkpfkzjts");
    }

    @Test
    public void testIsScramble() throws Exception {
        assert ScrambleString.isScramble("gr", "rg");
        assert ScrambleString.isScramble("great", "rgtae");
        assert ScrambleString.isScramble("great", "grtae");
        assert ScrambleString.isScramble("great", "great");
        assert ScrambleString.isScramble("great", "tearg");
        assert ScrambleString.isScramble("great", "tgrea");

        assert ScrambleString.isScramble("abc", "bca");

        assert ScrambleString.isScramble("xstjzkfpkggnhjzkpfjoguxvkbuopi", "xbouipkvxugojfpkzjhnggkpfkzjts");
    }

    @Test
    public void testIsScrambleDP() throws Exception {
        assert ScrambleString.isScrambleDP("gr", "rg");
        assert ScrambleString.isScrambleDP("great", "rgtae");
        assert ScrambleString.isScrambleDP("great", "grtae");
        assert ScrambleString.isScrambleDP("great", "great");
        assert ScrambleString.isScrambleDP("great", "tearg");
        assert ScrambleString.isScrambleDP("great", "tgrea");

        assert ScrambleString.isScrambleDP("abc", "bca");

        assert ScrambleString.isScrambleDP("xstjzkfpkggnhjzkpfjoguxvkbuopi", "xbouipkvxugojfpkzjhnggkpfkzjts");
    }
}