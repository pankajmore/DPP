package puzzles;

import org.jetbrains.annotations.NotNull;
import utils.Node;

/** Created by pankaj on 3/21/16. */
public class CyclicRightShift {
  /**
   * Time : O(N) Space: O(1)
   *
   * @param head a linked list of size N
   * @param k an integer
   * @return the new head by cyclically right shifting the list by k
   */
  public static Node cyclicallyRightShift(@NotNull Node head, int k) {
    int length = 1;
    Node curr = head;
    while (curr.next != null) {
      length++;
      curr = curr.next;
    }
    k %= length;
    int steps = length - k - 1;
    Node last = curr;
    curr = head;
    while (steps-- > 0) curr = curr.next;
    if (curr.next == null) return head;
    Node newHead = curr.next;
    curr.next = null;
    last.next = head;
    return newHead;
  }
}
