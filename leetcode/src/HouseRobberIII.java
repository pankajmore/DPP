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

  int rob2(final TreeNode root) {
    int[] res = robHelper(root);
    return Math.max(res[0], res[1]);
  }

  private int[] robHelper(final TreeNode root) {
    if (root == null) {
      return new int[] {0, 0};
    }
    int[] left = robHelper(root.left);
    int[] right = robHelper(root.right);
    int withRoot = root.val + left[1] + right[1];
    int withoutRoot = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
    return new int[] {withRoot, withoutRoot};
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
