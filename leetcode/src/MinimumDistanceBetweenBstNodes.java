/** https://leetcode.com/problems/minimum-distance-between-bst-nodes/description/ */
class MinimumDistanceBetweenBstNodes {
  int minDiffInBST(TreeNode root) {
    long[] res = new long[] {Integer.MIN_VALUE, Integer.MAX_VALUE};
    minDiffInBST(root, res);
    return (int) res[1];
  }

  private void minDiffInBST(TreeNode root, long[] res) {
    if (root == null) return;
    minDiffInBST(root.left, res);
    res[1] = Math.min(res[1], root.val - res[0]);
    res[0] = root.val;
    minDiffInBST(root.right, res);
  }

  private class TreeNode {
    private int val;
    private TreeNode left;
    private TreeNode right;
  }
}
