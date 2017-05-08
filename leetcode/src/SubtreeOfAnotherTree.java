/** https://leetcode.com/problems/subtree-of-another-tree/ Created by pankaj on 08/05/17. */
class SubtreeOfAnotherTree {
  boolean isSubtree(final TreeNode s, final TreeNode t) {
    return s != null && (equals(s, t) || isSubtree(s.left, t) || isSubtree(s.right, t));
  }

  private boolean equals(final TreeNode s, final TreeNode t) {
    if (s == null) {
      return t == null;
    } else {
      return t != null && s.val == t.val && equals(s.left, t.left) && equals(s.right, t.right);
    }
  }

  class TreeNode {
    private int val;
    private TreeNode left;
    private TreeNode right;
  }
}
