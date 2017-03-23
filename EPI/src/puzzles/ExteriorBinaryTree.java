package puzzles;

import utils.BinaryTreeNode;

import java.util.ArrayList;
import java.util.List;

/** Created by pankaj on 2/22/16. */
public class ExteriorBinaryTree {
  public static List<BinaryTreeNode> exterior(BinaryTreeNode root) {
    List<BinaryTreeNode> list = new ArrayList<>();
    list.add(root);
    leftExterior(root.left, list);
    bottomExterior(root, list);
    rightExterior(root.right, list);
    return list;
  }

  private static void leftExterior(BinaryTreeNode root, List<BinaryTreeNode> list) {
    if (root == null) return;
    if (root.left == null && root.right == null) return;
    list.add(root);
    leftExterior(root.left, list);
  }

  private static void bottomExterior(BinaryTreeNode root, List<BinaryTreeNode> list) {
    if (root == null) return;
    if (root.left == null && root.right == null) list.add(root);
    bottomExterior(root.left, list);
    bottomExterior(root.right, list);
  }

  private static void rightExterior(BinaryTreeNode root, List<BinaryTreeNode> list) {
    if (root == null) return;
    if (root.left == null && root.right == null) return;
    rightExterior(root.right, list);
    list.add(root);
  }
}
