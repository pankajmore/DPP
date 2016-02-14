package puzzles;

import examples.BinaryTreeExample;
import org.junit.Test;
import utils.BinaryTreeNode;

/**
 * Created by pankaj on 2/14/16.
 */
public class KBalancedBinaryTreeTest {

    @Test
    public void testKUnbalancedBinaryTree() throws Exception {
        BinaryTreeNode root = BinaryTreeExample.constructBookExample();
        assert new KBalancedBinaryTree().kUnbalancedBinaryTree(root, 3) == root.right.left;
    }
}