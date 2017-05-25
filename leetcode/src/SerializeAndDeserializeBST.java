import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
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
    return buildFromPreOrder(vals);
  }

  private void preOrder(final TreeNode root, final List<Integer> preOrder) {
    if (root != null) {
      preOrder.add(root.val);
      preOrder(root.left, preOrder);
      preOrder(root.right, preOrder);
    }
  }

  private TreeNode buildFromPreOrder(final List<Integer> preOrder) {
    if (preOrder.isEmpty()) {
      return null;
    } else {
      TreeNode root = new TreeNode(preOrder.get(0));
      int leftEnd = 1;
      while (leftEnd < preOrder.size() && preOrder.get(leftEnd) <= root.val) {
        leftEnd++;
      }
      root.left = buildFromPreOrder(preOrder.subList(1, leftEnd));
      root.right = buildFromPreOrder(preOrder.subList(leftEnd, preOrder.size()));
      return root;
    }
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
