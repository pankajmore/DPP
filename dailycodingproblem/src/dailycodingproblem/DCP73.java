package dailycodingproblem;

import java.util.ArrayList;
import java.util.List;

/** Given the head of a singly linked list, reverse it in-place. */
class DCP73 {
  static ListNode reverse(ListNode head) {
    ListNode prev = null;
    ListNode curr = head;
    while (curr != null) {
      ListNode next = curr.next;
      curr.next = prev;
      prev = curr;
      curr = next;
    }
    return prev;
  }

  static class ListNode {
    private final int val;
    private ListNode next;

    ListNode(int x) {
      val = x;
    }

    static ListNode fromList(List<Integer> list) {
      if (list == null || list.isEmpty()) {
        return null;
      }
      ListNode head = new ListNode(list.get(0));
      ListNode curr = head;
      for (int i = 1; i < list.size(); i++) {
        ListNode node = new ListNode(list.get(i));
        curr.next = node;
        curr = node;
      }
      return head;
    }

    static List<Integer> toList(ListNode head) {
      if (head == null) {
        return null;
      }
      List<Integer> list = new ArrayList<>();
      while (head != null) {
        list.add(head.val);
        head = head.next;
      }
      return list;
    }
  }
}
