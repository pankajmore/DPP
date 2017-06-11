/** https://leetcode.com/problems/merge-two-binary-trees/ Created by pankaj on 11/06/17. */
class MergeTwoBinaryTrees {
  TreeNode mergeTrees(final TreeNode t1, final TreeNode t2) {
    if (t1 == null && t2 == null) {
      return null;
    } else if (t1 == null) {
      return t2;
    } else if (t2 == null) {
      return t1;
    } else {
      TreeNode root = new TreeNode(t1.val + t2.val);
      root.left = mergeTrees(t1.left, t2.left);
      root.right = mergeTrees(t1.right, t2.right);
      return root;
    }
  }

  private class TreeNode {
    private int val;
    private TreeNode left;
    private TreeNode right;

    TreeNode(final int x) {
      val = x;
    }
  }
}
