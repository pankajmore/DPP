package puzzles;

import utils.BinaryTreeNode;

/** Created by pankaj on 2/24/16. */
public class ReconstructAlmostBST {
  private BinaryTreeNode _prev, _first, _second;

  public ReconstructAlmostBST() {
    _prev = new BinaryTreeNode(Integer.MIN_VALUE, null, null);
    _first = _second = null;
  }

  /**
   * Time : O(N) Space: O(H)
   *
   * <p>Converts it into a BST by swapping exactly 2 'out-of-place' nodes
   *
   * @param root a binary tree of size N and height H
   */
  public void reconstructBST(BinaryTreeNode root) {
    if (root == null) return;
    reconstructBSTHelper(root);
    if (_first == null || _second == null) return;
    int temp = _first.val();
    _first.val = _second.val;
    _second.val = temp;
  }

  private void reconstructBSTHelper(BinaryTreeNode root) {
    if (root == null) return;
    reconstructBSTHelper(root.left);
    if (_first == null && _prev.val() > root.val()) _first = _prev;
    if (_first != null && _prev.val() > root.val()) _second = root;
    _prev = root;
    reconstructBSTHelper(root.right);
  }
}
