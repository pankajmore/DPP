package puzzles;

import examples.BinaryTreeExample;
import org.junit.Test;
import puzzles.KthNodeBinaryTree.BinaryTreeNode;

import java.util.List;

import static puzzles.KthNodeBinaryTree.findKthNodeBinaryTree;
import static puzzles.KthNodeBinaryTree.kthNodeBinaryTree;

/** Created by pankaj on 2/21/16. */
public class KthNodeBinaryTreeTest {

  @Test
  public void testKthNodeBinaryTree() throws Exception {
    utils.BinaryTreeNode root = BinaryTreeExample.constructBookExample();
    List<utils.BinaryTreeNode> inOrder = root.inOrder();
    for (int i = 1; i <= inOrder.size(); i++)
      assert kthNodeBinaryTree(root, i) == inOrder.get(i - 1);
  }

  @Test
  public void testFindKthNodeBinaryTree() throws Exception {
    // size field
    //   6
    //  2  3
    // 1  1 1
    //
    // data field
    //   3
    //  2  5
    // 1  4 6
    BinaryTreeNode<Integer> root = new BinaryTreeNode<>();
    root.size = 6;
    root.data = 3;
    root.left = new BinaryTreeNode<>();
    root.left.size = 2;
    root.left.data = 2;
    root.left.left = new BinaryTreeNode<>();
    root.left.left.size = 1;
    root.left.left.data = 1;
    root.right = new BinaryTreeNode<>();
    root.right.size = 3;
    root.right.data = 5;
    root.right.left = new BinaryTreeNode<>();
    root.right.left.size = 1;
    root.right.left.data = 4;
    root.right.right = new BinaryTreeNode<>();
    root.right.right.size = 1;
    root.right.right.data = 6;
    // 0th node does not exist - leftmost node is node 1
    assert (null == findKthNodeBinaryTree(root, 0));
    // should output 1
    assert (findKthNodeBinaryTree(root, 1).data == 1);
    System.out.println((findKthNodeBinaryTree(root, 1)).data);
    // should output 2
    assert (findKthNodeBinaryTree(root, 2).data == 2);
    System.out.println((findKthNodeBinaryTree(root, 2)).data);
    // should output 3
    assert (findKthNodeBinaryTree(root, 3).data == 3);
    System.out.println((findKthNodeBinaryTree(root, 3)).data);
    // should output 4
    assert (findKthNodeBinaryTree(root, 4).data == 4);
    System.out.println((findKthNodeBinaryTree(root, 4)).data);
    // should output 5
    assert (findKthNodeBinaryTree(root, 5).data == 5);
    System.out.println((findKthNodeBinaryTree(root, 5)).data);
    // should output 6
    assert (findKthNodeBinaryTree(root, 6).data == 6);
    System.out.println((findKthNodeBinaryTree(root, 6)).data);
    // should throw
    assert (null == findKthNodeBinaryTree(root, 7));
  }
}
