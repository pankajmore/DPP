import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

/** https://leetcode.com/problems/serialize-and-deserialize-bst/ Created by pankaj on 25/05/17. */
class SerializeAndDeserializeBST {
  // Encodes a tree to a single string.
  String serialize(final TreeNode root) {
    List<Integer> preOrder = new ArrayList<>();
    preOrder(root, preOrder);
    return preOrder.toString();
  }

  // Decodes your encoded data to tree.
  TreeNode deserialize(final String data) {
    if (data.isEmpty() || data.equals("[]")) {
      return null;
    }
    List<String> ls = Arrays.asList(data.substring(1, data.length() - 1).split(", "));
    List<Integer> vals = ls.stream().map(Integer::parseInt).collect(Collectors.toList());
    List<Integer> split = nextGreater(vals);
    return buildFromPreOrder(0, vals.size() - 1, vals, split);
  }

  private void preOrder(final TreeNode root, final List<Integer> preOrder) {
    if (root != null) {
      preOrder.add(root.val);
      preOrder(root.left, preOrder);
      preOrder(root.right, preOrder);
    }
  }

  private TreeNode buildFromPreOrder(
      final int lo, final int hi, final List<Integer> preOrder, final List<Integer> split) {
    if (lo > hi) {
      return null;
    } else {
      TreeNode root = new TreeNode(preOrder.get(lo));
      int idx = split.get(lo);
      root.left = buildFromPreOrder(lo + 1, idx - 1, preOrder, split);
      root.right = buildFromPreOrder(idx, hi, preOrder, split);
      return root;
    }
  }

  private List<Integer> nextGreater(final List<Integer> ls) {
    List<Integer> nextGreater = new ArrayList<>();
    for (int i = 0; i < ls.size(); i++) {
      nextGreater.add(ls.size());
    }
    Stack<Integer> stack = new Stack<>();
    stack.push(0);
    for (int i = 1; i < ls.size(); i++) {
      while (!stack.isEmpty() && ls.get(stack.peek()) < ls.get(i)) {
        nextGreater.set(stack.peek(), i);
        stack.pop();
      }
      stack.push(i);
    }
    return nextGreater;
  }

  class TreeNode {
    private int val;
    private TreeNode left;
    private TreeNode right;

    TreeNode(final int v) {
      val = v;
    }
  }
}
