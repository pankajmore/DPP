import java.util.ArrayList;
import java.util.List;

/** https://leetcode.com/problems/binary-tree-paths/ Created by pankaj on 11/01/17. */
class BinaryTreePaths {
  List<String> binaryTreePaths(TreeNode root) {
    List<String> paths = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    binaryTreePathsHelper(root, path, paths);
    return paths;
  }

  private void binaryTreePathsHelper(TreeNode root, List<Integer> path, List<String> paths) {
    if (root == null) return;
    path.add(root.val);
    if (root.left == null && root.right == null) {
      paths.add(pathToString(path));
    }
    binaryTreePathsHelper(root.left, path, paths);
    binaryTreePathsHelper(root.right, path, paths);
    path.remove(path.size() - 1);
  }

  private String pathToString(List<Integer> path) {
    StringBuilder sb = new StringBuilder();
    for (int v : path) {
      if (sb.length() != 0) sb.append("->");
      sb.append(v);
    }
    return sb.toString();
  }

  private class TreeNode {
    int val;
    TreeNode left, right;
  }
}
