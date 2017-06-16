/** https://leetcode.com/problems/house-robber-iii/ Created by pankaj on 16/06/17. */
class HouseRobberIII {
  int rob(final TreeNode root) {
    if (root == null) {
      return 0;
    } else {
      int withRoot = root.val;
      int withoutRoot = rob(root.left) + rob(root.right);
      if (root.left != null) {
        withRoot += rob(root.left.left) + rob(root.left.right);
      }
      if (root.right != null) {
        withRoot += rob(root.right.left) + rob(root.right.right);
      }
      return Math.max(withRoot, withoutRoot);
    }
  }

  class TreeNode {
    private int val;
    private TreeNode left;
    private TreeNode right;
  }
}
