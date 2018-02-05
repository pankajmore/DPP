package dailycodingproblem;

import org.junit.jupiter.api.Test;

import static dailycodingproblem.DCP29.decode;
import static dailycodingproblem.DCP29.encode;
import static org.junit.jupiter.api.Assertions.assertEquals;

class DCP29Test {

    @Test
    void encodeTest() {
        assertEquals(null, encode(null));
        assertEquals("", encode(""));
        assertEquals("1A", encode("A"));
        assertEquals("1A2B1A", encode("ABBA"));
        assertEquals("4A3B2C1D2A", encode("AAAABBBCCDAA"));
    }

    @Test
    void decodeTest() {
        assertEquals(null, decode(null));
        assertEquals("", decode(""));
        assertEquals("A", decode("1A"));
        assertEquals("ABBA", decode("1A2B1A"));
        assertEquals("AAAABBBCCDAA", decode("4A3B2C1D2A"));
    }
}
