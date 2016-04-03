package puzzles;

import org.junit.Test;

import java.util.Arrays;

import static puzzles.ArrayEndReachable.isArrayEndReachable;
import static puzzles.ArrayEndReachable.isArrayEndReachableGreedy;

/**
 * Created by pankaj on 1/23/16.
 */
public class ArrayEndReachableTest {
    @Test
    public void testIsArrayEndReachable() throws Exception {
        assert isArrayEndReachable(Arrays.asList(3, 3, 1, 0, 2, 0, 1));
        assert !isArrayEndReachable(Arrays.asList(3, 2, 0, 0, 2, 0, 1));
        assert isArrayEndReachable(Arrays.asList(2, 3, 1, 1, 4));
        assert !isArrayEndReachable(Arrays.asList(3, 2, 1, 0, 4));
        assert !isArrayEndReachable(Arrays.asList(3, 2, 1, -10, 4));
        assert isArrayEndReachable(Arrays.asList(2, 3, -1, -1, 4));
        assert !isArrayEndReachable(Arrays.asList(2, 2, -1, -1, 100));
    }

    @Test
    public void testIsArrayEndReachableGreedy() throws Exception {
        assert isArrayEndReachableGreedy(Arrays.asList(3, 3, 1, 0, 2, 0, 1));
        assert !isArrayEndReachableGreedy(Arrays.asList(3, 2, 0, 0, 2, 0, 1));
        assert isArrayEndReachableGreedy(Arrays.asList(2, 3, 1, 1, 4));
        assert !isArrayEndReachableGreedy(Arrays.asList(3, 2, 1, 0, 4));
        assert !isArrayEndReachableGreedy(Arrays.asList(3, 2, 1, -10, 4));
        assert isArrayEndReachableGreedy(Arrays.asList(2, 3, -1, -1, 4));
        assert !isArrayEndReachableGreedy(Arrays.asList(2, 2, -1, -1, 100));
    }
}