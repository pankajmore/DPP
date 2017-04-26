import java.util.*;

/** https://leetcode.com/problems/binary-tree-inorder-traversal/ Created by pankaj on 26/04/17. */
public class BinaryTreeInorderTraversal {
  public List<Integer> inorderTraversal(TreeNode root) {
    List<Integer> inorder = new ArrayList<>();
    if (root == null) return inorder;
    Set<TreeNode> visited = new HashSet<>();
    Stack<TreeNode> stack = new Stack<>();
    stack.add(root);
    while (!stack.isEmpty()) {
      TreeNode t = stack.pop();
      if (visited.contains(t)) {
        inorder.add(t.val);
      } else {
        if (t.right != null) stack.add(t.right);
        stack.add(t);
        visited.add(t);
        if (t.left != null) stack.add(t.left);
      }
    }
    return inorder;
  }

  class TreeNode {
    int val;
    TreeNode left, right;
  }
}
