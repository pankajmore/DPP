package puzzles;

import org.junit.Test;

import java.util.Arrays;

import static puzzles.BinarySearchGreaterThanK.binarySearchGreaterThanK;

/**
 * Created by pankaj on 3/6/16.
 */
public class BinarySearchGreaterThanKTest {

    @Test
    public void testBinarySearchGreaterThanK() throws Exception {
        assert binarySearchGreaterThanK(Arrays.asList(1), 0) == 0;
        assert binarySearchGreaterThanK(Arrays.asList(1), 2) == -1;

        assert binarySearchGreaterThanK(Arrays.asList(1, 3, 3, 5, 8, 8, 10), 1) == 1;
        assert binarySearchGreaterThanK(Arrays.asList(1, 3, 3, 5, 8, 8, 10), 2) == 1;
        assert binarySearchGreaterThanK(Arrays.asList(1, 3, 3, 5, 8, 8, 10), 3) == 3;
        assert binarySearchGreaterThanK(Arrays.asList(1, 3, 3, 5, 8, 8, 10), 4) == 3;
        assert binarySearchGreaterThanK(Arrays.asList(1, 3, 3, 5, 8, 8, 10), 5) == 4;
        assert binarySearchGreaterThanK(Arrays.asList(1, 3, 3, 5, 8, 8, 10), 6) == 4;
        assert binarySearchGreaterThanK(Arrays.asList(1, 3, 3, 5, 8, 8, 10), 7) == 4;
        assert binarySearchGreaterThanK(Arrays.asList(1, 3, 3, 5, 8, 8, 10), 8) == 6;
        assert binarySearchGreaterThanK(Arrays.asList(1, 3, 3, 5, 8, 8, 10), 9) == 6;
        assert binarySearchGreaterThanK(Arrays.asList(1, 3, 3, 5, 8, 8, 10), 10) == -1;
    }
}