/**
 * https://leetcode.com/problems/second-minimum-node-in-a-binary-tree/
 * Created by pankaj on 03/09/17.
 */
class SecondMinimumNodeInABinaryTree {
  int findSecondMinimumValue(final TreeNode root) {
    if (root == null) {
      return -1;
    }
    return findMin(root, root.val);
  }

  private int findMin(final TreeNode root, final int val) {
    if (root == null) {
      return -1;
    } else if (root.val != val) {
      return root.val;
    } else {
      int left = findMin(root.left, val);
      int right = findMin(root.right, val);
      if (left == -1) {
        return right;
      } else if (right == -1) {
        return left;
      } else {
        return Math.min(left, right);
      }
    }
  }

  class TreeNode {
    private int val;
    private TreeNode left;
    private TreeNode right;
  }
}
