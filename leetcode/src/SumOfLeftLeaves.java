/** https://leetcode.com/problems/sum-of-left-leaves/ Created by pankaj on 08/12/16. */
public class SumOfLeftLeaves {
  public int sumOfLeftLeaves(TreeNode root) {
    if (root == null) return 0;
    return sumOfLeftLeavesHelper(root, false);
  }

  public int sumOfLeftLeavesHelper(TreeNode root, boolean left) {
    if (root == null) return 0;
    if (root.left == null && root.right == null && left) return root.val;
    return sumOfLeftLeavesHelper(root.left, true) + sumOfLeftLeavesHelper(root.right, false);
  }

  public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
      val = x;
    }
  }
}
