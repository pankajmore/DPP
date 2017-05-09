import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/** https://leetcode.com/problems/subtree-of-another-tree/ Created by pankaj on 08/05/17. */
class SubtreeOfAnotherTree {
  /**
   * Time : O(m * n) Space: O(m + n).
   *
   * @param s binary tree with m nodes
   * @param t binary tree with n nodes
   * @return tree iff t is a subtree of s
   */
  boolean isSubtree(final TreeNode s, final TreeNode t) {
    return s != null && (equals(s, t) || isSubtree(s.left, t) || isSubtree(s.right, t));
  }

  /**
   * Time : O(m + n) Space: O(m + n).
   *
   * @param s binary tree with m nodes
   * @param t binary tree with n nodes
   * @return tree iff t is a subtree of s
   */
  boolean isSubtree1(final TreeNode s, final TreeNode t) {
    if (s == null) {
      return false;
    }
    int h = hash(t).get(t);
    Map<TreeNode, Integer> hashMap = hash(s);
    return isSubtreeInternal(s, t, h, hashMap);
  }

  private boolean isSubtreeInternal(
      final TreeNode s, final TreeNode t, final int hash, final Map<TreeNode, Integer> hashMap) {
    if (s == null) {
      return false;
    } else {
      if (hashMap.get(s).equals(hash) && equals(s, t)) {
        return true;
      } else {
        return isSubtreeInternal(s.left, t, hash, hashMap)
            || isSubtreeInternal(s.right, t, hash, hashMap);
      }
    }
  }

  private Map<TreeNode, Integer> hash(final TreeNode root) {
    Map<TreeNode, Integer> hashMap = new HashMap<>();
    hashInternal(root, hashMap);
    return hashMap;
  }

  private Integer hashInternal(final TreeNode root, final Map<TreeNode, Integer> hashMap) {
    if (root == null) {
      return null;
    } else {
      Integer leftHash = hashInternal(root.left, hashMap);
      Integer rightHash = hashInternal(root.right, hashMap);
      Integer hash = Objects.hash(leftHash, root.val, rightHash);
      hashMap.put(root, hash);
      return hash;
    }
  }

  private boolean equals(final TreeNode s, final TreeNode t) {
    if (s == null) {
      return t == null;
    } else {
      return t != null && s.val == t.val && equals(s.left, t.left) && equals(s.right, t.right);
    }
  }

  class TreeNode {
    private int val;
    private TreeNode left;
    private TreeNode right;
  }
}
