/** https://leetcode.com/problems/remove-linked-list-elements/ Created by pankaj on 05/04/17. */
public class RemoveLinkedListElements {
  public ListNode removeElementsRecursive(ListNode head, int val) {
    if (head == null) return null;
    head.next = removeElementsRecursive(head.next, val);
    return head.val == val ? head.next : head;
  }

  public ListNode removeElements(ListNode head, int val) {
    ListNode dummyHead = new ListNode(0);
    ListNode curr = dummyHead, next;
    dummyHead.next = head;
    while (curr != null) {
      next = curr.next;
      while (next != null && next.val == val) {
        next = next.next;
      }
      curr.next = next;
      curr = curr.next;
    }
    return dummyHead.next;
  }

  private static class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
      this.val = val;
    }
  }
}
