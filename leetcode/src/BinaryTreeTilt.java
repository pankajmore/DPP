/** https://leetcode.com/problems/binary-tree-tilt/ Created by pankaj on 23/04/17. */
public class BinaryTreeTilt {
  public int findTilt(TreeNode root) {
    return findTiltHelper(root)[0];
  }

  private int[] findTiltHelper(TreeNode root) {
    if (root == null) return new int[] {0, 0};
    int[] l = findTiltHelper(root.left);
    int[] r = findTiltHelper(root.right);
    return new int[] {l[0] + r[0] + Math.abs(l[1] - r[1]), l[1] + r[1] + root.val};
  }

  class TreeNode {
    int val;
    TreeNode left, right;
  }
}
