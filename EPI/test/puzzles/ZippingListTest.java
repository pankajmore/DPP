package puzzles;

import com.pholser.junit.quickcheck.ForAll;
import org.junit.Assert;
import org.junit.Test;
import org.junit.contrib.theories.Theories;
import org.junit.contrib.theories.Theory;
import org.junit.runner.RunWith;
import utils.Node;

import java.util.Arrays;

import static puzzles.ZippingList.zip;
import static puzzles.ZippingList.zip1;

@RunWith(Theories.class)
public class ZippingListTest {

    @Test
    public void testZip() throws Exception {
        /* odd case */
        Node l = new Node(new int[]{0, 1, 2, 3, 4});
        Assert.assertEquals(zip(l).toList(), Arrays.asList(0, 4, 1, 3, 2));
        /* even case */
        l = new Node(new int[]{0, 1, 2, 3});
        Assert.assertEquals(zip(l).toList(), Arrays.asList(0, 3, 1, 2));
    }

    @Theory
    public void compare(@ForAll int[] A) throws Exception {
        if (A.length == 0) return;
        Assert.assertEquals(zip(new Node(A)), zip1(new Node(A)));
    }
}