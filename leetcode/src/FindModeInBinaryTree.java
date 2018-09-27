import java.util.*;

/**
 * https://leetcode.com/contest/leetcode-weekly-contest-17/problems/find-mode-in-binary-tree/
 * Created by pankaj on 29/01/17.
 */
class FindModeInBinaryTree {
  int[] findMode(TreeNode root) {
    List<Integer> A = new ArrayList<>();
    inorder(root, A);
    Map<Integer, Integer> cnt = new HashMap<>();
    for (int x : A) {
      cnt.put(x, cnt.getOrDefault(x, 0) + 1);
    }
    List<Integer> l = new ArrayList<>();
    int max = Collections.max(cnt.values());
    for (int x : cnt.keySet()) {
      int c = cnt.get(x);
      if (c == max) l.add(x);
    }
    int[] res = new int[l.size()];
    for (int i = 0; i < res.length; i++) {
      res[i] = l.get(i);
    }
    return res;
  }

  private void inorder(TreeNode root, List<Integer> A) {
    if (root == null) return;
    inorder(root.left, A);
    A.add(root.val);
    inorder(root.right, A);
  }

  private static class TreeNode {
    int val;
    TreeNode left, right;
  }
}
