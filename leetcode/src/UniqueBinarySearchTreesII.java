import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/** https://leetcode.com/problems/unique-binary-search-trees-ii/ Created by pankaj on 12/05/17. */
class UniqueBinarySearchTreesII {
  List<TreeNode> generateTrees(final int n) {
    if (n == 0) {
      return Collections.emptyList();
    }
    return generateTreesInternal(1, n);
  }

  private List<TreeNode> generateTreesInternal(final int lo, final int hi) {
    List<TreeNode> trees = new ArrayList<>();
    if (lo > hi) {
      trees.add(null);
      return trees;
    }
    for (int val = lo; val <= hi; val++) {
      for (TreeNode left : generateTreesInternal(lo, val - 1)) {
        for (TreeNode right : generateTreesInternal(val + 1, hi)) {
          TreeNode root = new TreeNode(val);
          root.left = left;
          root.right = right;
          trees.add(root);
        }
      }
    }
    return trees;
  }

  class TreeNode {
    private int val;
    private TreeNode left;
    private TreeNode right;

    TreeNode(final int x) {
      this.val = x;
    }
  }
}
