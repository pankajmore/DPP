package utils;

import org.jetbrains.annotations.NotNull;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/** Created by pankaj on 3/29/16. */
public class CartesianTree {
  private final BinaryTreeNode _tree;

  public CartesianTree(@NotNull List<Integer> A) {
    if (A.isEmpty()) _tree = null;
    else _tree = build(A);
  }

  /**
   * Time : O(N) Space: O(N)
   *
   * @param A list of N integers
   * @return the Binary "Cartesian" tree corresponding to A
   */
  private BinaryTreeNode build(List<Integer> A) {
    BinaryTreeNode curr = new BinaryTreeNode(A.get(0), null, null), next, parent;
    Map<BinaryTreeNode, BinaryTreeNode> parentMap = new HashMap<>();
    for (int i = 1; i < A.size(); i++) {
      int x = A.get(i);
      next = new BinaryTreeNode(x, null, null);
      parent = parentMap.get(curr);
      while (parent != null && curr.val > x) {
        curr = parent;
        parent = parentMap.get(curr);
      }
      if (parent == null) {
        next.left = curr;
        parentMap.put(curr, next);
      } else {
        curr.left = curr.right;
        curr.right = next;
        parentMap.put(next, curr);
      }
      curr = next;
    }
    BinaryTreeNode root = curr;
    while (parentMap.get(root) != null) root = parentMap.get(root);
    return root;
  }

  public List<Integer> sequence() {
    if (_tree == null) return Collections.emptyList();
    return _tree.inOrderVals();
  }
}
