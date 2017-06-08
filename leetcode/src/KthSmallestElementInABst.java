import java.util.ArrayList;
import java.util.List;

/** https://leetcode.com/problems/kth-smallest-element-in-a-bst/ Created by pankaj on 08/06/17. */
class KthSmallestElementInABst {
  int kthSmallest(final TreeNode root, final int k) {
    return inorder(root).get(k - 1);
  }

  private List<Integer> inorder(final TreeNode root) {
    List<Integer> inorder = new ArrayList<>();
    inorderInternal(root, inorder);
    return inorder;
  }

  private void inorderInternal(final TreeNode root, final List<Integer> inorder) {
    if (root != null) {
      inorderInternal(root.left, inorder);
      inorder.add(root.val);
      inorderInternal(root.right, inorder);
    }
  }

  private class TreeNode {
    private int val;
    private TreeNode left;
    private TreeNode right;
  }
}
