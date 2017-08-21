import java.util.HashSet;
import java.util.Set;

/** https://leetcode.com/problems/equal-tree-partition/ Created by pankaj on 21/08/17. */
class EqualTreePartition {
  boolean checkEqualTree(TreeNode root) {
    Set<Integer> set = new HashSet<>();
    int s = sum(root, root, set);
    return s % 2 == 0 && set.contains(s / 2);
  }

  private int sum(TreeNode root, TreeNode curr, Set<Integer> set) {
    if (curr == null) {
      return 0;
    }
    int s = curr.val + sum(root, curr.left, set) + sum(root, curr.right, set);
    if (curr != root) {
      set.add(s);
    }
    return s;
  }

  class TreeNode {
    private int val;
    private TreeNode left;
    private TreeNode right;
  }
}
