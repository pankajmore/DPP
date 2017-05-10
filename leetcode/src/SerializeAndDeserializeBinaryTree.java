import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * https://leetcode.com/problems/serialize-and-deserialize-binary-tree/ Created by pankaj on
 * 10/05/17.
 */
class SerializeAndDeserializeBinaryTree {
  // Encodes a tree to a single string.
  String serialize(final TreeNode root) {
    StringBuilder sb = new StringBuilder();
    serializeInternal(root, sb);
    return sb.toString();
  }

  private void serializeInternal(final TreeNode root, final StringBuilder sb) {
    if (root == null) {
      sb.append("# ");
    } else {
      sb.append(root.val).append(' ');
      serializeInternal(root.left, sb);
      serializeInternal(root.right, sb);
    }
  }

  // Decodes your encoded data to tree.
  TreeNode deserialize(final String data) {
    String[] ls = data.split(" ");
    List<String> vals = Arrays.stream(ls).collect(Collectors.toList());
    Iterator<String> iter = vals.iterator();
    return deserializeInternal(iter);
  }

  private TreeNode deserializeInternal(final Iterator<String> iter) {
    String next = iter.next();
    if (next.equals("#")) {
      return null;
    } else {
      TreeNode root = new TreeNode(Integer.parseInt(next));
      root.left = deserializeInternal(iter);
      root.right = deserializeInternal(iter);
      return root;
    }
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
