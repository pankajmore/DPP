package utils;

import examples.BinaryTreeExample;
import org.junit.Assert;
import org.junit.Test;

import java.util.Collections;
import java.util.List;

/** Created by pankaj on 6/16/16. */
public class ThreadedBinaryTreeTest {
  @Test
  public void testInOrderMorris() {
    ThreadedBinaryTree n = ThreadedBinaryTree.construct(BinaryTreeExample.threadedExample());
    Assert.assertEquals(n.inOrder(), n.inOrderMorris());
    List<ThreadedBinaryTree> inOrder = n.inOrderMorrisReverse();
    Collections.reverse(inOrder);
    Assert.assertEquals(n.inOrder(), inOrder);
  }

  @Test
  public void testParentMorris() {
    ThreadedBinaryTree n = ThreadedBinaryTree.construct(BinaryTreeExample.threadedExample());
    for (ThreadedBinaryTree node : n.inOrderMorris()) {
      final ThreadedBinaryTree expected = node.parent(n);
      final ThreadedBinaryTree actual = node.parentMorris();
      Assert.assertEquals(expected, actual);
      if (actual != null) Assert.assertTrue(actual.left == node || actual.right == node);
    }
  }
}
