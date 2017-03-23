package puzzles;

import org.junit.Assert;
import org.junit.Test;
import utils.Node;

import static puzzles.OverlappingLists.overlappingList;

/** Created by pankaj on 5/14/16. */
public class OverlappingListsTest {
  @Test
  public void testOverlappingList() throws Exception {
    //different chains
    Node l1 = new Node(new int[] {1, 2, 3});
    Node l2 = new Node(new int[] {4, 5, 6});
    Assert.assertNull(overlappingList(l1, l2));
    l1.next = l2.next; // connect l1 and l2 (no cycles)
    Assert.assertEquals(overlappingList(l1, l2), l1.next);

    // different cycles
    l1 = new Node(new int[] {1, 2, 3, 4, 5});
    l1.introduceCycle(3);
    l2 = new Node(new int[] {1, 2, 3, 4, 5});
    l2.introduceCycle(4);
    Assert.assertNull(overlappingList(l1, l2));

    // overlap before cycle
    l1 = new Node(new int[] {1, 2, 3, 4, 5});
    l1.introduceCycle(4);
    l2 = new Node(new int[] {1, 2, 3});
    l2.next.next.next = l1.next;
    Assert.assertEquals(overlappingList(l1, l2), l1.next);

    // overlap inside cycle
    l1 = new Node(new int[] {1, 2, 3, 4, 5});
    l1.introduceCycle(3);
    l2 = new Node(new int[] {1, 2, 3});
    l2.next.next.next = l1.next.next.next;
    Assert.assertEquals(overlappingList(l1, l2), l1.next.next);
  }
}
