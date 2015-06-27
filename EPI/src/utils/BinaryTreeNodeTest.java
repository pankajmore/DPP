package utils;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

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
        BinaryTreeNode root = constructBookExample();
        List<List<Integer>> ls = root.levelOrderByDepth();
        List<List<Integer>> es = new ArrayList<List<Integer>>();
        es = Arrays.asList(
                Arrays.asList(314),
                Arrays.asList(6,6),
                Arrays.asList(271,561,2,271),
                Arrays.asList(28,0,3,1,28),
                Arrays.asList(17,401,257),
                Arrays.asList(641)
        );
        assert(ls.equals(es));

    }

    private BinaryTreeNode constructBookExample(){
        BinaryTreeNode l = new BinaryTreeNode(6,new BinaryTreeNode(271,new BinaryTreeNode(28,null,null),new BinaryTreeNode(0,null,null)),new BinaryTreeNode(561,null,new BinaryTreeNode(3,new BinaryTreeNode(17,null,null),null)));
        BinaryTreeNode r = new BinaryTreeNode(6,new BinaryTreeNode(2,null,new BinaryTreeNode(1,new BinaryTreeNode(401,null,new BinaryTreeNode(641,null,null)),new BinaryTreeNode(257,null,null))),new BinaryTreeNode(271,null,new BinaryTreeNode(28,null,null)));
        BinaryTreeNode root = new BinaryTreeNode(314,l,r);
        return root;
    }

    @Test
    public void testHeight() throws Exception {
        BinaryTreeNode n = new BinaryTreeNode(1,null,null);
        assertTrue(n.height() == 0);
        assertTrue(constructBookExample().height() == 5);
    }

    @Test
    public void testIsBalanced() throws Exception {
        assertTrue(!constructBookExample().isBalancedSlow());
        assertTrue(!constructBookExample().isBalanced());
        BinaryTreeNode balancedTree = new BinaryTreeNode(1,new BinaryTreeNode(2,new BinaryTreeNode(3,new BinaryTreeNode(4,new BinaryTreeNode(5,null,null),new BinaryTreeNode(6,null,null)),new BinaryTreeNode(7,null,null)),new BinaryTreeNode(8,new BinaryTreeNode(9,null,null),new BinaryTreeNode(10,null,null))),new BinaryTreeNode(11,new BinaryTreeNode(12,new BinaryTreeNode(13,null,null),new BinaryTreeNode(14,null,null)),new BinaryTreeNode(15,null,null)));
        assertTrue(balancedTree.isBalancedSlow());
        assertTrue(balancedTree.isBalanced());
    }
}