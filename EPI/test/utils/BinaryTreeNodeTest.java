package utils;

import examples.BinaryTreeExample;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static junit.framework.TestCase.assertFalse;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class BinaryTreeNodeTest {
    @Test
    public void testLevelOrderByDepth() throws Exception {
        BinaryTreeNode root = BinaryTreeExample.constructBookExample();
        List<List<Integer>> ls = root.levelOrderByDepth();
        List<List<Integer>> es = Arrays.asList(
                Arrays.asList(314),
                Arrays.asList(6, 6),
                Arrays.asList(271, 561, 2, 271),
                Arrays.asList(28, 0, 3, 1, 28),
                Arrays.asList(17, 401, 257),
                Arrays.asList(641));
        Assert.assertEquals(es, ls);
    }

    @Test
    public void testHeight() throws Exception {
        BinaryTreeNode n = new BinaryTreeNode(1, null, null);
        assertEquals(0, n.height());
        assertEquals(5, BinaryTreeExample.constructBookExample().height());
    }

    @Test
    public void testIsBalanced() throws Exception {
        assertTrue(!BinaryTreeExample.constructBookExample().isBalancedSlow());
        assertTrue(!BinaryTreeExample.constructBookExample().isBalanced());
        BinaryTreeNode balancedTree = new BinaryTreeNode(1, new BinaryTreeNode(2, new BinaryTreeNode(3, new BinaryTreeNode(4, new BinaryTreeNode(5, null, null), new BinaryTreeNode(6, null, null)), new BinaryTreeNode(7, null, null)), new BinaryTreeNode(8, new BinaryTreeNode(9, null, null), new BinaryTreeNode(10, null, null))), new BinaryTreeNode(11, new BinaryTreeNode(12, new BinaryTreeNode(13, null, null), new BinaryTreeNode(14, null, null)), new BinaryTreeNode(15, null, null)));
        assertTrue(balancedTree.isBalancedSlow());
        assertTrue(balancedTree.isBalanced());
    }

    @Test
    public void testisBST() {
        BinaryTreeNode tree = BinaryTreeExample.constructBSTExample();
        Assert.assertTrue(tree.isBinarySearchTree());
        Assert.assertTrue(tree.isBSTPostOrderImpl().second());
        Assert.assertTrue(tree.isBSTInOrderImpl().second());
        Assert.assertTrue(tree.isBSTRange());

        BinaryTreeNode notBST = BinaryTreeExample.constructBookExample();
        List<Integer> inOrder = notBST.inOrder().stream().map(x -> x.val()).collect(Collectors.toList());
        List<Integer> inOrderSorted = new ArrayList<>(inOrder);
        Collections.sort(inOrderSorted);
        assertFalse(inOrder.equals(inOrderSorted));
        assertFalse(notBST.isBinarySearchTree());
        assertFalse(notBST.isBSTPostOrderImpl().second());
        assertFalse(notBST.isBSTInOrderImpl().second());
        assertFalse(notBST.isBSTRange());
    }

    @Test
    public void testSuccessor() {
        BinaryTreeNode tree = BinaryTreeExample.constructBSTExample();
        Assert.assertNotNull(tree.successor(23));
        Assert.assertEquals(29, tree.successor(23).val());
        Assert.assertNull(tree.successor(32));

    }

    @Test
    public void testIsSymmetric() throws Exception {
        Assert.assertTrue(BinaryTreeExample.symmetricTree().isSymmetric());
        Assert.assertFalse(BinaryTreeExample.constructBookExample().isSymmetric());
    }

    @Test
    public void testInOrderPreOrder() throws Exception {
        BinaryTreeNode tree = BinaryTreeExample.constructBSTExample();
        BinaryTreeNode derivedFromPreOrder = BinaryTreeNode.construct(tree.inOrderVals(), tree.preOrderVals());
        BinaryTreeNode derivedFromPostOrder = BinaryTreeNode.construct(tree.inOrderVals(), tree.postOrderVals());
        Assert.assertEquals(tree, derivedFromPreOrder);
        Assert.assertEquals(tree, derivedFromPostOrder);
    }

    @Test
    public void testLeastCommonAncestorDistinctBST() throws Exception {
        BinaryTreeNode root = BinaryTreeExample.constructBSTExample();
        BinaryTreeNode x = root.left().left();
        BinaryTreeNode y = root.left().right().right();
        BinaryTreeNode l = root.left();
        Assert.assertEquals(l, root.leastCommonAncestorDistinctBST(x, y));
    }

    @Test
    public void testInOrderUsingStack() throws Exception {
        BinaryTreeNode tree = BinaryTreeExample.constructBookExample();
        Assert.assertEquals(tree.inOrder(), tree.inOrderUsingStack());
        Assert.assertEquals(tree.inOrder(), tree.inOrderUsingStack1());
    }

    @Test
    public void testPreOrderUsingStack() throws Exception {
        BinaryTreeNode tree = BinaryTreeExample.constructBookExample();
        Assert.assertEquals(tree.preOrder(), tree.preOrderUsingStack());
    }

    @Test
    public void testPostOrderUsingStack() throws Exception {
        BinaryTreeNode tree = BinaryTreeExample.constructBookExample();
        Assert.assertEquals(tree.postOrder(), tree.postOrderUsingStack());
    }

    @Test
    public void testLeastCommonAncestor() throws Exception {
        BinaryTreeNode root = BinaryTreeExample.constructBookExample();
        Assert.assertEquals(root, root.leastCommonAncestor(root.left, root.right));
        Assert.assertEquals(root.left, root.leastCommonAncestor(root.left.left.left, root.left.right.right.left));
        Assert.assertEquals(root, root.leastCommonAncestor(root.left.right, root.right.left.right));
    }
}