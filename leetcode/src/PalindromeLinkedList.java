/** https://leetcode.com/problems/palindrome-linked-list/ Created by pankaj on 02/08/17. */
class PalindromeLinkedList {
  boolean isPalindrome(final ListNode head) {
    if (head == null || head.next == null) {
      return true;
    }
    ListNode slow = head;
    ListNode fast = head;
    while (fast.next != null && fast.next.next != null) {
      fast = fast.next.next;
      slow = slow.next;
    }
    ListNode r = slow.next;
    slow.next = null;
    r = reverse(r);
    ListNode s = head;
    while (s != null && r != null) {
      if (s.val != r.val) {
        return false;
      }
      s = s.next;
      r = r.next;
    }
    return true;
  }

  private ListNode reverse(final ListNode head) {
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
