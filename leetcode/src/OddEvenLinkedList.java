/** https://leetcode.com/problems/odd-even-linked-list/ Created by pankaj on 14/06/17. */
class OddEvenLinkedList {
  ListNode oddEvenList(final ListNode head) {
    ListNode oddHead = new ListNode(0);
    ListNode evenHead = new ListNode(0);
    ListNode oddPtr = oddHead;
    ListNode evenPtr = evenHead;
    ListNode curr = head;
    for (int idx = 1; curr != null; idx++) {
      ListNode next = curr.next;
      curr.next = null;
      if (idx % 2 == 0) {
        evenPtr.next = curr;
        evenPtr = evenPtr.next;
      } else {
        oddPtr.next = curr;
        oddPtr = oddPtr.next;
      }
      curr = next;
    }
    oddPtr.next = evenHead.next;
    return oddHead.next;
  }

  private class ListNode {
    private int val;
    private ListNode next;

    ListNode(final int x) {
      val = x;
    }
  }
}
