package puzzles;

import com.pholser.junit.quickcheck.ForAll;
import org.junit.Assert;
import org.junit.Test;
import org.junit.contrib.theories.Theories;
import org.junit.contrib.theories.Theory;
import org.junit.runner.RunWith;

import java.util.Random;

import static puzzles.RabinKarp.rabinKarp;

@RunWith(Theories.class)
public class RabinKarpTest {

    @Theory
    public void compare(@ForAll String t) {
        int N = t.length();
        if(N == 0) return;
        int idx = new Random().nextInt(N);
        String s = t.substring(idx, idx + new Random().nextInt(t.length() - idx));
        Assert.assertEquals(t.indexOf(s), rabinKarp(t, s));
    }

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