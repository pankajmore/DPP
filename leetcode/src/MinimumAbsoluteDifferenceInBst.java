/**
 * https://leetcode.com/problems/minimum-absolute-difference-in-bst/ Created by pankaj on 29/03/17.
 */
public class MinimumAbsoluteDifferenceInBst {
  public int getMinimumDifference(TreeNode root) {
    int[] last = new int[] {-1};
    int[] min = new int[] {Integer.MAX_VALUE};
    minimumDifferenceHelper(root, last, min);
    return min[0];
  }

  private void minimumDifferenceHelper(TreeNode root, int[] last, int[] min) {
    if (root == null) return;
    minimumDifferenceHelper(root.left, last, min);
    min[0] = Math.min(min[0], last[0] == -1 ? Integer.MAX_VALUE : root.val - last[0]);
    last[0] = root.val;
    minimumDifferenceHelper(root.right, last, min);
  }

  private static class TreeNode {
    int val;
    TreeNode left, right;
  }
}
