/**
 * https://leetcode.com/problems/construct-string-from-binary-tree/ Created by pankaj on 04/06/17.
 */
class ConstructStringFromBinaryTree {
  String tree2str(final TreeNode t) {
    if (t == null) {
      return "";
    }
    StringBuilder sb = new StringBuilder();
    sb.append(t.val);
    String left = tree2str(t.left);
    String right = tree2str(t.right);
    if (t.left != null || t.right != null) {
      sb.append('(');
      sb.append(left);
      sb.append(')');
    }
    if (t.right != null) {
      sb.append('(');
      sb.append(right);
      sb.append(')');
    }
    return sb.toString();
  }

  private class TreeNode {
    private int val;
    private TreeNode left;
    private TreeNode right;
  }
}
