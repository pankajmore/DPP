package puzzles;

import org.junit.Test;
import utils.Node;

import java.util.Arrays;

import static puzzles.ZippingList.zip;

public class ZippingListTest {

    @Test
    public void testZip() throws Exception {
        /* odd case */
        Node l = new Node(new int[]{0, 1, 2, 3, 4});
        assert zip(l).toList().equals(Arrays.asList(0, 4, 1, 3, 2));
        /* even case */
        l = new Node(new int[]{0, 1, 2, 3});
        assert zip(l).toList().equals(Arrays.asList(0, 3, 1, 2));

    }
}