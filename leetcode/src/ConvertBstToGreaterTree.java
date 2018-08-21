/** https://leetcode.com/problems/convert-bst-to-greater-tree/ Created by pankaj on 22/03/17. */
class ConvertBstToGreaterTree {
  TreeNode convertBST(TreeNode root) {
    convertBSTHelper(root, 0);
    return root;
  }

  private int convertBSTHelper(TreeNode root, int sum) {
    if (root == null) return sum;
    root.val += convertBSTHelper(root.right, sum);
    return convertBSTHelper(root.left, root.val);
  }

  class TreeNode {
    int val;
    TreeNode left, right;
  }
}