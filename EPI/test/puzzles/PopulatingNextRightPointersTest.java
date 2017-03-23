package puzzles;

import org.junit.Test;
import puzzles.PopulatingNextRightPointers.BinaryTreeNode;

import static puzzles.PopulatingNextRightPointers.populateNextPointer;
import static puzzles.PopulatingNextRightPointers.populateNextPointer1;

public class PopulatingNextRightPointersTest {
  @Test
  public void testPopulateNextRightPointer() throws Exception {
    //     3
    //  2     5
    BinaryTreeNode<Integer> root = new BinaryTreeNode<>(3);
    root.left = new BinaryTreeNode<>(2);
    root.right = new BinaryTreeNode<>(5);
    populateNextPointer(root);
    assert (root.next == null);
    assert (root.left.next == root.right);
    assert (root.right.next == null);

    //     3
    //  2     5
    // 1 7   4 6
    root = new BinaryTreeNode<>(3);
    root.left = new BinaryTreeNode<>(2);
    root.left.right = new BinaryTreeNode<>(7);
    root.left.left = new BinaryTreeNode<>(1);
    root.right = new BinaryTreeNode<>(5);
    root.right.left = new BinaryTreeNode<>(4);
    root.right.right = new BinaryTreeNode<>(6);
    populateNextPointer(root);
    assert (root.next == null);
    assert (root.left.next == root.right);
    assert (root.left.left.next == root.left.right);
    assert (root.left.right.next == root.right.left);
    assert (root.right.left.next == root.right.right);
  }

  @Test
  public void testPopulateNextRightPointer1() throws Exception {
    //     3
    //  2     5
    BinaryTreeNode<Integer> root = new BinaryTreeNode<>(3);
    root.left = new BinaryTreeNode<>(2);
    root.right = new BinaryTreeNode<>(5);
    populateNextPointer1(root);
    assert (root.next == null);
    assert (root.left.next == root.right);
    assert (root.right.next == null);

    //     3
    //  2     5
    // 1 7   4 6
    root = new BinaryTreeNode<>(3);
    root.left = new BinaryTreeNode<>(2);
    root.left.right = new BinaryTreeNode<>(7);
    root.left.left = new BinaryTreeNode<>(1);
    root.right = new BinaryTreeNode<>(5);
    root.right.left = new BinaryTreeNode<>(4);
    root.right.right = new BinaryTreeNode<>(6);
    populateNextPointer1(root);
    assert (root.next == null);
    assert (root.left.next == root.right);
    assert (root.left.left.next == root.left.right);
    assert (root.left.right.next == root.right.left);
    assert (root.right.left.next == root.right.right);
  }
}
