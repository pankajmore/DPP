import java.util.ArrayList;
import java.util.List;

/** https://leetcode.com/problems/find-leaves-of-binary-tree Created by pankaj on 11/08/17. */
class FindLeavesOfBinaryTree {
  List<List<Integer>> findLeaves(final TreeNode root) {
    List<List<Integer>> list = new ArrayList<>();
    leavesHelper(root, list);
    return list;
  }

  int leavesHelper(final TreeNode root, final List<List<Integer>> list) {
    if (root == null) {
      return -1;
    }
    int l = leavesHelper(root.left, list);
    int r = leavesHelper(root.right, list);
    int idx = 1 + Math.max(l, r);
    if (idx == list.size()) {
      list.add(new ArrayList<>());
    }
    list.get(idx).add(root.val);
    return idx;
  }

  class TreeNode {
    private int val;
    private TreeNode left;
    private TreeNode right;
  }
}
