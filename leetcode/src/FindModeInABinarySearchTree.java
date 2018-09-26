/** https://leetcode.com/problems/find-mode-in-binary-search-tree/ Created by pankaj on 08/04/17. */
class FindModeInABinarySearchTree {
  private int currCount = 0, maxCount = 0, modeCount = 0;
  private int currVal;
  private int[] modes = null;

  int[] findMode(TreeNode root) {
    inOrder(root);
    modes = new int[modeCount];
    currCount = 0;
    modeCount = 0;
    inOrder(root);
    return modes;
  }

  private void handleValue(int val) {
    if (val != currVal) {
      currVal = val;
      currCount = 0;
    }
    currCount++;
    if (currCount > maxCount) {
      maxCount = currCount;
      modeCount = 1;
    } else if (currCount == maxCount) {
      if (modes != null) {
        modes[modeCount] = val;
      }
      modeCount++;
    }
  }

  private void inOrder(TreeNode root) {
    if (root != null) {
      inOrder(root.left);
      handleValue(root.val);
      inOrder(root.right);
    }
  }

  private static class TreeNode {
    int val;
    TreeNode left, right;
  }
}
