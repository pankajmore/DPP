package dailycodingproblem;

import org.junit.jupiter.api.Test;

import static dailycodingproblem.DCP20180108.productExceptSelf;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class DCP20180108Test {

    @Test
    void productExceptSelfTest() {
        assertArrayEquals(new int[]{}, productExceptSelf(new int[]{}));
        assertArrayEquals(new int[]{1}, productExceptSelf(new int[]{0}));
        assertArrayEquals(new int[]{-2, -3}, productExceptSelf(new int[]{-3, -2}));
        assertArrayEquals(new int[]{0, 1}, productExceptSelf(new int[]{1, 0}));
        assertArrayEquals(new int[]{0, 6, 0}, productExceptSelf(new int[]{2, 0, 3}));
        assertArrayEquals(new int[]{2, 3, 6}, productExceptSelf(new int[]{3, 2, 1}));
        assertArrayEquals(
                new int[]{120, 60, 40, 30, 24}, productExceptSelf(new int[]{1, 2, 3, 4, 5}));
    }
}
