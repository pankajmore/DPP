/** https://leetcode.com/problems/trim-a-binary-search-tree/ Created by pankaj on 03/09/17. */
class TrimABinarySearchTree {
  TreeNode trimBST(final TreeNode root, final int l, final int r) {
    if (root == null) {
      return null;
    } else if (root.val < l) {
      return trimBST(root.right, l, r);
    } else if (root.val > r) {
      return trimBST(root.left, l, r);
    } else {
      root.left = trimBST(root.left, l, r);
      root.right = trimBST(root.right, l, r);
      return root;
    }
  }

  class TreeNode {
    private int val;
    private TreeNode left;
    private TreeNode right;
  }
}
