/** https://leetcode.com/problems/diameter-of-binary-tree/ Created by pankaj on 20/03/17. */
public class DiameterOfBinaryTree {
  public int diameterOfBinaryTree(TreeNode root) {
    if (root == null) return 0;
    return diameter(root)[0] - 1;
  }

  private int[] diameter(TreeNode root) {
    if (root == null) return new int[] {0, 0};
    int[] left = diameter(root.left);
    int[] right = diameter(root.right);
    int h = Math.max(left[1], right[1]) + 1;
    int d = Math.max(left[1] + right[1] + 1, Math.max(left[0], right[0]));
    return new int[] {d, h};
  }

  public static class TreeNode {
    int val;
    TreeNode left, right;
  }
}
