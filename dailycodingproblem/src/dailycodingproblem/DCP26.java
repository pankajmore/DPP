package dailycodingproblem;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a singly linked list and an integer k, remove the kth last element from the list. k is
 * guaranteed to be smaller than the length of the list.
 */
class DCP26 {
  /**
   * @param head head of the linked list
   * @param k 1 indexed,
   */
  static Node removeKthLast(Node head, int k) {
    assert k > 0;
    Node fakeHead = new Node(0);
    fakeHead.next = head;
    Node slow = fakeHead, fast = fakeHead;
    for (int i = 0; i <= k; i++) {
      fast = fast.next;
    }
    while (fast != null) {
      fast = fast.next;
      slow = slow.next;
    }
    slow.next = slow.next.next;
    return fakeHead.next;
  }

  static class Node {
    int val;
    Node next;

    Node(int v) {
      val = v;
      next = null;
    }

    static List<Integer> toList(Node head) {
      Node curr = head;
      List<Integer> list = new ArrayList<>();
      while (curr != null) {
        list.add(curr.val);
        curr = curr.next;
      }
      return list;
    }

    static Node fromList(List<Integer> values) {
      if (values == null || values.isEmpty()) {
        return null;
      } else {
        Node head = new Node(values.get(0));
        head.next = fromList(values.subList(1, values.size()));
        return head;
      }
    }
  }
}
