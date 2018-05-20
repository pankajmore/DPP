import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/** https://leetcode.com/problems/invert-binary-tree/ Created by pankaj on 10/6/16. */
public class InvertTree {
  public TreeNode invertTree(TreeNode root) {
    if (root == null) return null;
    TreeNode tmp = invertTree(root.right);
    root.right = invertTree(root.left);
    root.left = tmp;
    return root;
  }

  public TreeNode invertTreeUsingStack(TreeNode root) {
    Stack<TreeNode> stack = new Stack<>();
    if (root != null) stack.push(root);
    while (!stack.isEmpty()) {
      TreeNode curr = stack.pop();
      TreeNode left = curr.left, right = curr.right;
      curr.left = right;
      curr.right = left;
      if (curr.left != null) stack.push(curr.left);
      if (curr.right != null) stack.push(curr.right);
    }
    return root;
  }

  public TreeNode invertTreeUsingQueue(TreeNode root) {
    Deque<TreeNode> queue = new LinkedList<>();
    if (root != null) queue.push(root);
    while (!queue.isEmpty()) {
      TreeNode curr = queue.remove();
      TreeNode left = curr.left, right = curr.right;
      curr.left = right;
      curr.right = left;
      if (left != null) queue.add(left);
      if (right != null) queue.add(right);
    }
    return root;
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
