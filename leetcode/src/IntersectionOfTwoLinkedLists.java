/**
 * https://leetcode.com/problems/intersection-of-two-linked-lists/ Created by pankaj on 07/06/17.
 */
class IntersectionOfTwoLinkedLists {
  ListNode getIntersectionNode(final ListNode headA, final ListNode headB) {
    ListNode a = headA;
    ListNode b = headB;
    while (a != b) {
      if (a == null) {
        a = headB;
      } else {
        a = a.next;
      }
      if (b == null) {
        b = headA;
      } else {
        b = b.next;
      }
    }
    return a;
  }

  private class ListNode {
    private int val;
    private ListNode next;
  }
}
