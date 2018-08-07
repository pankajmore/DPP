/**
 * https://leetcode.com/problems/binary-tree-longest-consecutive-sequence-ii Created by pankaj on
 * 15/04/17.
 */
class BinaryTreeLongestConsecutiveSequenceII {
  private int max = 0;

  int longestConsecutive(TreeNode root) {
    longestConsecutiveHelper(root);
    return max;
  }

  private int[] longestConsecutiveHelper(TreeNode root) {
    if (root == null) return new int[] {0, 0};
    int inc = 1, dec = 1;
    if (root.left != null) {
      int[] l = longestConsecutiveHelper(root.left);
      if (root.val + 1 == root.left.val) {
        inc = l[1] + 1;
      } else if (root.val == root.left.val + 1) {
        dec = l[0] + 1;
      }
    }
    if (root.right != null) {
      int[] r = longestConsecutiveHelper(root.right);
      if (root.val + 1 == root.right.val) {
        inc = Math.max(inc, r[1] + 1);
      } else if (root.val == root.right.val + 1) {
        dec = Math.max(dec, r[0] + 1);
      }
    }
    max = Math.max(max, inc + dec - 1);
    return new int[] {dec, inc};
  }

  private static class TreeNode {
    int val;
    TreeNode left, right;
  }
}
