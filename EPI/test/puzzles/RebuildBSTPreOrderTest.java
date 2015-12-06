package puzzles;

import examples.BinaryTreeExample;
import org.junit.Test;
import utils.BinaryTree;
import utils.BinaryTreeNode;

import java.util.Arrays;
import java.util.List;

import static puzzles.RebuildBSTPreOrder.rebuildBSTFromPreOrder;

public class RebuildBSTPreOrderTest {

    @Test
    public void testRebuildBSTFromPreOrder() throws Exception {
        List<Integer> preOrderSequence = Arrays.asList(
                19, 7, 3, 2, 5, 11, 17, 13, 43, 23, 37, 29, 31, 41, 47, 53
        );
        final BinaryTreeNode expected = BinaryTreeExample.constructBSTExample();
        final BinaryTreeNode actual = rebuildBSTFromPreOrder(preOrderSequence);
        assert actual.equals(expected);
    }
}