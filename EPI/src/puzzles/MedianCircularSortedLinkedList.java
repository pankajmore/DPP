package puzzles;

import com.sun.istack.internal.NotNull;
import utils.Node;

/** Created by pankaj on 5/25/16. */
public class MedianCircularSortedLinkedList {
  public static int median(@NotNull Node l) {
    Node curr = l.next;
    while (curr != null && curr != l && curr.next != null && curr.val <= curr.next.val) {
      curr = curr.next;
    }
    if (curr == null) throw new IllegalArgumentException("List is not circular" + l.toString());
    if (curr == l) return curr.val;
    Node head = curr.next, last = curr;
    last.next = null;
    Node slow = head, fast = head;
    int N = 0;
    while (fast != null && fast.next != null && fast.next.next != null) {
      slow = slow.next;
      fast = fast.next.next;
      N += 2;
    }
    if (fast != null) N++;
    if (fast != null && fast.next != null) N++;
    assert head.length() == N;
    int median = N % 2 == 1 ? slow.val : (slow.val + slow.next.val) / 2;
    last.next = head;
    return median;
  }
}
