/**
 * https://leetcode.com/problems/intersection-of-two-linked-lists/ Created by pankaj on 07/06/17.
 */
class IntersectionOfTwoLinkedLists {
  ListNode getIntersectionNode(ListNode headA, ListNode headB) {
    int lenA = length(headA);
    int lenB = length(headB);
    if (lenB > lenA) {
      ListNode tmp = headA;
      headA = headB;
      headB = tmp;
      lenA = lenA ^ lenB;
      lenB = lenA ^ lenB;
      lenA = lenA ^ lenB;
    }
    int m = lenA - lenB;
    while (m > 0) {
      headA = headA.next;
      m--;
    }
    while (headA != null && headB != null) {
      if (headA == headB) {
        return headA;
      }
      headA = headA.next;
      headB = headB.next;
    }
    return null;
  }

  private int length(ListNode head) {
    int len = 0;
    while (head != null) {
      len++;
      head = head.next;
    }
    return len;
  }

  private class ListNode {
    private int val;
    private ListNode next;
  }
}
