package puzzles;

import org.junit.Test;

import static puzzles.RomanToInteger.romanToInteger;

public class RomanToIntegerTest {

    @Test
    public void testRomanToInteger() throws Exception {
        assert 7 == romanToInteger("VII");
        assert 184 == romanToInteger("CLXXXIV");
        assert 9 == romanToInteger("IX");
        assert 40 == romanToInteger("XL");
        assert 60 == romanToInteger("LX");
        assert 1500 == romanToInteger("MD");
        assert 400 == romanToInteger("CD");
        assert 1900 == romanToInteger("MCM");
        assert 9919 == romanToInteger("MMMMMMMMMCMXIX");
    }
}