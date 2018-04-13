/** https://leetcode.com/problems/balanced-binary-tree/ Created by pankaj on 8/17/16. */
class BalancedBinaryTree {
  boolean isBalanced(TreeNode root) {
    if (root == null) return true;
    return Math.abs(depth(root.left) - depth(root.right)) <= 1
        && isBalanced(root.left)
        && isBalanced(root.right);
  }

  int depth(TreeNode root) {
    if (root == null) return 0;
    return 1 + Math.max(depth(root.left), depth(root.right));
  }

  class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
      val = x;
    }
  }
}
