package puzzles;

import examples.BinaryTreeExample;
import org.junit.Test;
import utils.BinaryTreeNode;

import java.util.ArrayList;
import java.util.List;

public class FindKLargestBSTTest {

    @Test
    public void testFindKLargestInBSTTrivial() throws Exception {
        BinaryTreeNode bst = BinaryTreeExample.constructBSTExample();
        List<Integer> expected = FindKLargestBST.findKLargestInBSTTrivial(bst, 3);
        List<Integer> actual = new ArrayList<>();
        actual.add(53);
        actual.add(47);
        actual.add(43);
        assert (actual.equals(expected));
    }
}