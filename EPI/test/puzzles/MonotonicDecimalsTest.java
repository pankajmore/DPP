package puzzles;

import org.junit.Test;

import static org.junit.Assert.*;
import static puzzles.MonotonicDecimals.numberOfMonotonicDecimals;

public class MonotonicDecimalsTest {

    @Test
    public void testNumberOfMonotonicDecimals() throws Exception {
        assert numberOfMonotonicDecimals(0) == 0;
        assert numberOfMonotonicDecimals(1) == 9;
        assert numberOfMonotonicDecimals(2) == 45;
    }
}