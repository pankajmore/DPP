package utils;

import examples.BinaryTreeExample;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static junit.framework.TestCase.assertFalse;
import static org.junit.Assert.assertTrue;

public class BinaryTreeNodeTest {

    @Test
    public void testInOrder() throws Exception {

    }

    @Test
    public void testPreOrder() throws Exception {

    }

    @Test
    public void testPostOrder() throws Exception {

    }

    @Test
    public void testLevelOrder() throws Exception {

    }

    @Test
    public void testLevelOrderByDepth() throws Exception {
        BinaryTreeNode root = BinaryTreeExample.constructBookExample();
        List<List<Integer>> ls = root.levelOrderByDepth();
        List<List<Integer>> es = new ArrayList<List<Integer>>();
        es = Arrays.asList(
                Arrays.asList(314),
                Arrays.asList(6, 6),
                Arrays.asList(271, 561, 2, 271),
                Arrays.asList(28, 0, 3, 1, 28),
                Arrays.asList(17, 401, 257),
                Arrays.asList(641)
        );
        assert (ls.equals(es));

    }

    @Test
    public void testHeight() throws Exception {
        BinaryTreeNode n = new BinaryTreeNode(1, null, null);
        assertTrue(n.height() == 0);
        assertTrue(BinaryTreeExample.constructBookExample().height() == 5);
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
        assert (tree.isBinarySearchTree());
        assert (tree.isBSTPostOrderImpl().second());
        assert (tree.isBSTInOrderImpl().second());
        assert (tree.isBSTRange());

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
        assert (tree.successor(23) != null);
        assert (tree.successor(23).val() == 29);
        assert (tree.successor(32) == null);

    }

    @Test
    public void testIsSymmetric() throws Exception {
        assert BinaryTreeExample.symmetricTree().isSymmetric();

    }

    @Test
    public void testInOrderPreOrder() throws Exception {
        BinaryTreeNode tree = BinaryTreeExample.constructBSTExample();
        BinaryTreeNode derivedFromPreOrder = BinaryTreeNode.construct(tree.inOrderVals(), tree.preOrder());
        BinaryTreeNode derivedFromPostOrder = BinaryTreeNode.construct(tree.inOrderVals(), tree.postOrder());
        assert tree.equals(derivedFromPreOrder);
        assert tree.equals(derivedFromPostOrder);
    }

    @Test
    public void testLeastCommonAncestorDistinctBST() throws Exception {
        BinaryTreeNode root = BinaryTreeExample.constructBSTExample();
        BinaryTreeNode x = root.left().left();
        BinaryTreeNode y = root.left().right().right();
        BinaryTreeNode l = root.left();
        assert l.equals(root.leastCommonAncestorDistinctBST(x, y));
    }
}