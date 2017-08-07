import java.util.ArrayList;
import java.util.List;

/** https://leetcode.com/problems/print-binary-tree/ Created by pankaj on 07/08/17. */
class PrintBinaryTree {
  List<List<String>> printTree(final TreeNode root) {
    int h = height(root);
    int w = (1 << h) - 1;
    List<List<String>> levels = new ArrayList<>();
    for (int i = 0; i < h; i++) {
      List<String> level = new ArrayList<>(w);
      for (int j = 0; j < w; j++) {
        level.add("");
      }
      levels.add(level);
    }
    fill(root, levels, 0, w - 1, 0);
    return levels;
  }

  private void fill(
      final TreeNode root,
      final List<List<String>> levels,
      final int lo,
      final int hi,
      final int row) {
    if (root == null) {
      return;
    }
    int mid = (lo + hi) >>> 1;
    levels.get(row).set(mid, String.valueOf(root.val));
    fill(root.left, levels, lo, mid - 1, row + 1);
    fill(root.right, levels, mid + 1, hi, row + 1);
  }

  private int height(final TreeNode root) {
    if (root == null) {
      return 0;
    }
    return 1 + Math.max(height(root.left), height(root.right));
  }

  class TreeNode {
    private int val;
    private TreeNode left;
    private TreeNode right;
  }
}
