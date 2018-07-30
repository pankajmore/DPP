/** https://leetcode.com/problems/minimum-depth-of-binary-tree/ Created by pankaj on 17/01/17. */
class MinimumDepthOfBinaryTree {
  int minDepth(TreeNode root) {
    if (root == null) return 0;
    if (root.left == null) return 1 + minDepth(root.right);
    if (root.right == null) return 1 + minDepth(root.left);
    return 1 + Math.min(minDepth(root.left), minDepth(root.right));
  }

  private static class TreeNode {
    int val;
    TreeNode left, right;
  }
}
