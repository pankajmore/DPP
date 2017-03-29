/**
 * https://leetcode.com/problems/minimum-absolute-difference-in-bst/ Created by pankaj on 29/03/17.
 */
public class MinimumAbsoluteDifferenceInBst {
  public int getMinimumDifference(TreeNode root) {
    return minimumDifferenceHelper(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
  }

  private int minimumDifferenceHelper(TreeNode root, int lo, int hi) {
    int min = Integer.MAX_VALUE;
    if (root == null) return min;
    if (lo != Integer.MIN_VALUE) min = Math.min(min, root.val - lo);
    min = Math.min(min, hi - root.val);
    min = Math.min(min, minimumDifferenceHelper(root.left, lo, root.val));
    min = Math.min(min, minimumDifferenceHelper(root.right, root.val, hi));
    return min;
  }

  private static class TreeNode {
    int val;
    TreeNode left, right;
  }
}
