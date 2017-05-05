/** https://leetcode.com/problems/reverse-nodes-in-k-group/ Created by pankaj on 05/05/17. */
class ReverseNodesInKGroup {
  ListNode reverseKGroup(final ListNode head, final int k) {
    ListNode curr = head;
    int cnt = k;
    while (curr != null && --cnt > 0) {
      curr = curr.next;
    }
    if (curr == null) {
      return head;
    }
    ListNode newHead = curr, next = curr.next;
    curr.next = null;
    reverse(head);
    head.next = reverseKGroup(next, k);
    return newHead;
  }

  ListNode reverse(final ListNode head) {
    if (head == null || head.next == null) {
      return head;
    }
    ListNode prev = null;
    ListNode curr = head;
    ListNode next;
    while (curr != null) {
      next = curr.next;
      curr.next = prev;
      prev = curr;
      curr = next;
    }
    return prev;
  }

  class ListNode {
    private int val;
    private ListNode next;
  }
}
