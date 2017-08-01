/** https://leetcode.com/problems/closest-binary-search-tree-value Created by pankaj on 01/08/17. */
class ClosestBinarySearchTreeValue {
  int closestValue(final TreeNode root, final int target) {
    TreeNode curr = root;
    int closest = curr.val;
    while (curr != null) {
      if (Math.abs(closest - target) >= Math.abs(curr.val - target)) {
        closest = curr.val;
      }
      if (curr.val > target) {
        curr = curr.left;
      } else {
        curr = curr.right;
      }
    }
    return closest;
  }

  class TreeNode {
    private int val;
    private TreeNode left;
    private TreeNode right;
  }
}
