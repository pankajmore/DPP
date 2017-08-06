/** https://leetcode.com/problems/two-sum-iv-input-is-a-bst/ Created by pankaj on 06/08/17. */
class TwoSumIV {
  public boolean findTarget(final TreeNode root, final int k) {
    return root != null && findTargetHelper(root, root, k);
  }

  private boolean findTargetHelper(final TreeNode root, final TreeNode curr, final int k) {
    if (curr == null) {
      return false;
    }
    TreeNode candidate = find(root, k - curr.val);
    return (candidate != null && candidate != curr)
        || findTargetHelper(root, curr.left, k)
        || findTargetHelper(root, curr.right, k);
  }

  private TreeNode find(final TreeNode root, final int x) {
    TreeNode curr = root;
    while (curr != null) {
      if (curr.val < x) {
        curr = curr.right;
      } else if (curr.val > x) {
        curr = curr.left;
      } else {
        return curr;
      }
    }
    return null;
  }

  class TreeNode {
    private int val;
    private TreeNode left;
    private TreeNode right;
  }
}
