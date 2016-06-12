package utils;

import examples.BinaryTreeExample;
import org.junit.Assert;
import org.junit.Test;

//TODO: Generate and test on random trees
public class BinaryTreeNodeWithParentTest {
    @Test
    public void testDepth() {
        BinaryTreeNodeWithParent bookExample = new BinaryTreeNodeWithParent(BinaryTreeExample.constructBookExample());
        Assert.assertEquals(0, bookExample.depth());
        Assert.assertEquals(3, bookExample.left().left().right().depth());
        Assert.assertEquals(4, bookExample.right().left().right().left().depth());
    }

    @Test
    public void testInOrder() throws Exception {
        BinaryTreeNodeWithParent bookExample = new BinaryTreeNodeWithParent(BinaryTreeExample.constructBookExample());
        int[] actual = bookExample.inOrder().stream().mapToInt(BinaryTreeNodeWithParent::val).toArray();
        int[] expected = BinaryTreeExample.constructBookExample().inOrder().stream().mapToInt(BinaryTreeNode::val).toArray();
        Assert.assertArrayEquals(expected, actual);
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
        Assert.assertEquals(l, root.leastCommonAncestor(x, y));
        Assert.assertEquals(l, root.leastCommonAncestorHashTable(x, y));
    }
}