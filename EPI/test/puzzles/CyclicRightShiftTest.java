package puzzles;

import org.junit.Test;
import utils.Node;

import java.util.Arrays;

import static puzzles.CyclicRightShift.cyclicallyRightShift;

/**
 * Created by pankaj on 3/21/16.
 */
public class CyclicRightShiftTest {

    @Test
    public void testCyclicallyRightShift() throws Exception {
        Node original = new Node(new int[]{1, 2, 3, 4, 5});
        Node shifted = cyclicallyRightShift(original, 3);
        assert shifted.toList().equals(Arrays.asList(3, 4, 5, 1, 2));
    }
}