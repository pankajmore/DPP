package utils;

import examples.BinaryTreeExample;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

//TODO: Generate and test on random trees
public class BinaryTreeNodeWithParentTest {
    @Test
    public void testDepth() {
        BinaryTreeNodeWithParent bookExample = new BinaryTreeNodeWithParent(BinaryTreeExample.constructBookExample());
        assert bookExample.depth() == 0;
        assert bookExample.left().left().right().depth() == 3;
        assert bookExample.right().left().right().left().depth() == 4;
    }

    @Test
    public void testInOrder() throws Exception {
        BinaryTreeNodeWithParent bookExample = new BinaryTreeNodeWithParent(BinaryTreeExample.constructBookExample());
        int[] actual = bookExample.inOrder().stream().mapToInt(BinaryTreeNodeWithParent::val).toArray();
        int[] expected = BinaryTreeExample.constructBookExample().inOrder().stream().mapToInt(BinaryTreeNode::val).toArray();
        assert Arrays.equals(actual, expected);
    }

    @Test
    public void testPreOrder() throws Exception {
        BinaryTreeNodeWithParent bookExample = new BinaryTreeNodeWithParent(BinaryTreeExample.constructBookExample());
        int[] actual = bookExample.preOrder().stream().mapToInt(BinaryTreeNodeWithParent::val).toArray();
        int[] expected = BinaryTreeExample.constructBookExample().preOrder().stream().mapToInt(BinaryTreeNode::val).toArray();
        Assert.assertArrayEquals(expected, actual);
    }

    @Test
    public void testPostOrder() throws Exception {
        BinaryTreeNodeWithParent bookExample = new BinaryTreeNodeWithParent(BinaryTreeExample.constructBookExample());
        int[] actual = bookExample.postOrder().stream().mapToInt(BinaryTreeNodeWithParent::val).toArray();
        int[] expected = BinaryTreeExample.constructBookExample().postOrder().stream().mapToInt(BinaryTreeNode::val).toArray();
        Assert.assertArrayEquals(expected, actual);
    }

    @Test
    public void testLeastCommonAncestor() {
        BinaryTreeNodeWithParent root = new BinaryTreeNodeWithParent(BinaryTreeExample.constructBSTExample());
        BinaryTreeNodeWithParent x = root.left().left();
        BinaryTreeNodeWithParent y = root.left().right().right();
        BinaryTreeNodeWithParent l = root.left();
        assert l.equals(root.leastCommonAncestor(x, y));
        assert l.equals(root.leastCommonAncestorHashTable(x, y));
    }
}