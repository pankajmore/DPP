package puzzles;

import org.junit.Assert;
import org.junit.Test;
import utils.Node;

import static puzzles.ListPivoting.listPivoting;

/** Created by pankaj on 5/26/16. */
public class ListPivotingTest {
  @Test
  public void testListPivoting() throws Exception {
    Assert.assertEquals(new Node(new int[] {1}), listPivoting(new Node(new int[] {1}), 3));
    Assert.assertEquals(new Node(new int[] {3}), listPivoting(new Node(new int[] {3}), 3));
    Assert.assertEquals(new Node(new int[] {5}), listPivoting(new Node(new int[] {5}), 3));
    Assert.assertEquals(new Node(new int[] {1, 3}), listPivoting(new Node(new int[] {1, 3}), 3));
    Assert.assertEquals(new Node(new int[] {3, 5}), listPivoting(new Node(new int[] {3, 5}), 3));
    Assert.assertEquals(new Node(new int[] {1, 5}), listPivoting(new Node(new int[] {5, 1}), 3));
    Assert.assertEquals(
        new Node(new int[] {1, 3, 5}), listPivoting(new Node(new int[] {5, 1, 3}), 3));
    Assert.assertEquals(
        new Node(new int[] {1, 3, 3, 5}), listPivoting(new Node(new int[] {5, 3, 1, 3}), 3));
  }
}
