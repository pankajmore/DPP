package puzzles;

import org.junit.Test;

import static puzzles.Multiply.multiply;

/**
 * Created by pankaj on 2/12/16.
 */
public class MultiplyTest {

    @Test
    public void testMultiply() throws Exception {
        assert multiply(1, 1) == 1;
        assert multiply(3, 4) == 12;
        assert multiply(65535, 65535) == 65535 * 65535;
    }
}