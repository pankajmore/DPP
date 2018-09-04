/**
 * https://leetcode.com/contest/leetcode-weekly-contest-19/problems/find-left-most-element/ Created
 * by pankaj on 13/02/17.
 */
class FindLeftMostElement {
  int findLeftMostNode(TreeNode root) {
    return find(root, 0)[0];
  }

  int[] find(TreeNode root, int depth) {
    if (root == null) return new int[] {-1, -1};
    int[] left = find(root.left, depth + 1);
    int[] right = find(root.right, depth + 1);
    if (left[1] == -1 && right[1] == -1) {
      return new int[] {root.val, depth};
    } else if (left[1] == -1) {
      return right;
    } else if (right[1] == -1) {
      return left;
    } else {
      return left[1] >= right[1] ? left : right;
    }
  }

  class TreeNode {
    int val;
    TreeNode left, right;
  }
}
