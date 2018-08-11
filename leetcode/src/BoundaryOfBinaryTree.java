import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/** https://leetcode.com/problems/boundary-of-binary-tree/ Created by pankaj on 28/03/17. */
class BoundaryOfBinaryTree {
  List<Integer> boundaryOfBinaryTree(TreeNode root) {
    List<Integer> boundary = new ArrayList<>();
    if (root == null) return boundary;
    boundary.add(root.val);
    if (root.left == null && root.right == null) return boundary;
    TreeNode left = root.left;
    while (left != null) {
      boundary.add(left.val);
      left = left.left != null ? left.left : left.right;
    }
    List<Integer> ls = new ArrayList<>();
    leaves(root, ls);
    if (root.left != null && ls.size() >= 1) ls = ls.subList(1, ls.size());
    boundary.addAll(ls);
    Stack<Integer> s = new Stack<>();
    TreeNode right = root.right;
    while (right != null) {
      s.add(right.val);
      right = right.right != null ? right.right : right.left;
    }
    if (!s.isEmpty()) s.pop();
    while (!s.isEmpty()) boundary.add(s.pop());
    return boundary;
  }

  private void leaves(TreeNode root, List<Integer> leaves) {
    if (root == null) return;
    leaves(root.left, leaves);
    if (root.left == null && root.right == null) leaves.add(root.val);
    leaves(root.right, leaves);
  }

  private static class TreeNode {
    int val;
    TreeNode left, right;
  }
}
