/** https://leetcode.com/problems/maximum-binary-tree/ Created by pankaj on 07/08/17. */
class MaximumBinaryTree {
  TreeNode constructMaximumBinaryTree(final int[] nums) {
    return constructMaximumBinaryTreeHelper(nums, 0, nums.length - 1);
  }

  private TreeNode constructMaximumBinaryTreeHelper(final int[] nums, final int lo, final int hi) {
    if (lo > hi) {
      return null;
    }
    int maxIdx = idxOfMax(nums, lo, hi);
    TreeNode root = new TreeNode(nums[maxIdx]);
    root.left = constructMaximumBinaryTreeHelper(nums, lo, maxIdx - 1);
    root.right = constructMaximumBinaryTreeHelper(nums, maxIdx + 1, hi);
    return root;
  }

  private int idxOfMax(final int[] nums, final int lo, final int hi) {
    int idx = lo;
    int max = nums[lo];
    for (int i = lo + 1; i <= hi; i++) {
      if (nums[i] > max) {
        max = nums[i];
        idx = i;
      }
    }
    return idx;
  }

  class TreeNode {
    private int val;
    private TreeNode left;
    private TreeNode right;

    TreeNode(final int v) {
      val = v;
    }
  }
}
