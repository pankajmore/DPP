import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/** https://leetcode.com/problems/add-one-row-to-tree/ Created by pankaj on 19/06/17. */
class AddOneRowToTree {
  TreeNode addOneRow(final TreeNode root, final int v, final int d) {
    if (d == 1) {
      TreeNode newRoot = new TreeNode(v);
      newRoot.left = root;
      return newRoot;
    }
    for (TreeNode node : getNodesAtDepth(Collections.singletonList(root), d - 1)) {
      TreeNode left = node.left;
      TreeNode right = node.right;
      node.left = new TreeNode(v);
      node.left.left = left;
      node.right = new TreeNode(v);
      node.right.right = right;
    }
    return root;
  }

  private List<TreeNode> getNodesAtDepth(final List<TreeNode> nodes, final int d) {
    if (d == 1) {
      return nodes;
    } else {
      List<TreeNode> next = new ArrayList<>();
      for (TreeNode node : nodes) {
        if (node.left != null) {
          next.add(node.left);
        }
        if (node.right != null) {
          next.add(node.right);
        }
      }
      return getNodesAtDepth(next, d - 1);
    }
  }

  class TreeNode {
    private TreeNode left;
    private TreeNode right;
    private int val;

    TreeNode(final int v) {
      val = v;
    }
  }
}
