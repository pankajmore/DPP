package puzzles;

import org.junit.Test;

import static puzzles.RabinKarp.rabinKarp;

public class RabinKarpTest {

    @Test
    public void testRabinKarp() throws Exception {
        assert rabinKarp("GACGCCA", "CGC") == 2;
        assert rabinKarp("GATACCCATCGAGTCGGATCGAGT", "GAG") == 10;
        assert rabinKarp("FOOBARWIDGET", "WIDGETS") == -1;
        assert rabinKarp("A", "A") == 0;
        assert rabinKarp("A", "B") == -1;
        assert rabinKarp("A", "") == 0;
        assert rabinKarp("ADSADA", "") == 0;
        assert rabinKarp("", "A") == -1;
        assert rabinKarp("", "AAA") == -1;
        assert rabinKarp("A", "AAA") == -1;
        assert rabinKarp("AA", "AAA") == -1;
        assert rabinKarp("AAA", "AAA") == 0;
        assert rabinKarp("BAAAA", "AAA") == 1;
        assert rabinKarp("BAAABAAAA", "AAA") == 1;
        assert rabinKarp("BAABBAABAAABS", "AAA") == 8;
        assert rabinKarp("BAABBAABAAABS", "AAAA") == -1;
        assert rabinKarp("FOOBAR", "BAR") > 0;
    }
}