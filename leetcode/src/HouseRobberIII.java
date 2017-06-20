import java.util.HashMap;
import java.util.Map;

/** https://leetcode.com/problems/house-robber-iii/ Created by pankaj on 16/06/17. */
class HouseRobberIII {
  int rob(final TreeNode root) {
    if (root == null) {
      return 0;
    } else {
      int withRoot = root.val;
      int withoutRoot = rob(root.left) + rob(root.right);
      if (root.left != null) {
        withRoot += rob(root.left.left) + rob(root.left.right);
      }
      if (root.right != null) {
        withRoot += rob(root.right.left) + rob(root.right.right);
      }
      return Math.max(withRoot, withoutRoot);
    }
  }

  int robDP(final TreeNode root) {
    return robInternal(root, new HashMap<>());
  }

  private int robInternal(final TreeNode root, final Map<TreeNode, Integer> map) {
    if (root == null) {
      return 0;
    } else if (map.containsKey(root)) {
      return map.get(root);
    } else {
      int withoutRoot = robInternal(root.left, map) + robInternal(root.right, map);
      int withRoot = root.val;
      if (root.left != null) {
        withRoot += robInternal(root.left.left, map) + robInternal(root.left.right, map);
      }
      if (root.right != null) {
        withRoot += robInternal(root.right.left, map) + robInternal(root.right.right, map);
      }
      int max = Math.max(withRoot, withoutRoot);
      map.put(root, max);
      return max;
    }
  }

  class TreeNode {
    private int val;
    private TreeNode left;
    private TreeNode right;
  }
}
