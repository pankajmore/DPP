import java.util.ArrayList;
import java.util.List;

/** https://leetcode.com/problems/binary-tree-preorder-traversal/ Created by pankaj on 07/04/17. */
public class BinaryTreePreOrderTraversal {
  public List<Integer> preorderTraversal(TreeNode root) {
    List<Integer> preOrder = new ArrayList<>();
    preOrderHelper(root, preOrder);
    return preOrder;
  }

  private void preOrderHelper(TreeNode root, List<Integer> preOrder) {
    if (root != null) {
      preOrder.add(root.val);
      preOrderHelper(root.left, preOrder);
      preOrderHelper(root.right, preOrder);
    }
  }

  private static class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode(int val) {
      this.val = val;
    }
  }
}