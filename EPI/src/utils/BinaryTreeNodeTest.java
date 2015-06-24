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
}