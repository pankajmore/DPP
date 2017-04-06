import java.util.Random;

/** https://leetcode.com/problems/linked-list-random-node/ Created by pankaj on 06/04/17. */
public class LinkedListRandomNode {
  private ListNode head;
  private Random rand;

  /**
   * @param head The linked list's head. Note that the head is guaranteed to be not null, so it
   *     contains at least one node.
   */
  public LinkedListRandomNode(ListNode head) {
    this.head = head;
    this.rand = new Random();
  }

  /** Returns a random node's value. */
  public int getRandom() {
    ListNode c = head;
    int r = c.val;
    for (int i = 1; c.next != null; i++) {
      c = c.next;
      if (rand.nextInt(i + 1) == 0) r = c.val;
    }
    return r;
  }

  private static class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
      this.val = val;
    }
  }
}
