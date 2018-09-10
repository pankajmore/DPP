/**
 * https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/ Created by pankaj
 * on 28/12/16.
 */
class LowestCommonAncestorOfABinarySearchTree {
  TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    while (root != null) {
      if (root.val > p.val && root.val > q.val) {
        root = root.left;
      } else if (root.val < p.val && root.val < q.val) {
        root = root.right;
      } else {
        return root;
      }
    }
    return null;
  }

  private static class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode(int x) {
      val = x;
    }
  }
}
