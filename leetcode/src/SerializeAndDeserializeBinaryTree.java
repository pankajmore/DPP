import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode.com/problems/serialize-and-deserialize-binary-tree/ Created by pankaj on
 * 10/05/17.
 */
class SerializeAndDeserializeBinaryTree {
  // Encodes a tree to a single string.
  String serialize(final TreeNode root) {
    List<Integer> s = new ArrayList<>();
    Deque<TreeNode> q = new LinkedList<>();
    q.add(root);
    while (!q.isEmpty()) {
      TreeNode curr = q.remove();
      if (curr == null) {
        s.add(null);
      } else {
        s.add(curr.val);
        q.add(curr.left);
        q.add(curr.right);
      }
    }
    return s.toString();
  }

  // Decodes your encoded data to tree.
  TreeNode deserialize(final String data) {
    String[] ls = data.substring(1, data.length() - 1).split(", ");
    List<Integer> vals = new ArrayList<>();
    for (String s : ls) {
      if (s.equals("null")) {
        vals.add(null);
      } else {
        vals.add(Integer.parseInt(s));
      }
    }
    if (vals.isEmpty()) {
      return null;
    }
    Deque<TreeNode> q = new LinkedList<>();
    TreeNode root;
    if (vals.get(0) == null) {
      root = null;
    } else {
      root = new TreeNode(vals.get(0));
    }
    q.add(root);
    int i = 0;
    while (!q.isEmpty()) {
      TreeNode curr = q.remove();
      if (curr != null) {
        Integer leftValue = vals.get(++i);
        Integer rightValue = vals.get(++i);
        if (leftValue == null) {
          curr.left = null;
        } else {
          curr.left = new TreeNode(leftValue);
        }
        if (rightValue == null) {
          curr.right = null;
        } else {
          curr.right = new TreeNode(rightValue);
        }
        q.add(curr.left);
        q.add(curr.right);
      }
    }
    return root;
  }

  class TreeNode {
    private final int val;
    private TreeNode left;
    private TreeNode right;

    TreeNode(final int x) {
      val = x;
    }
  }
}
