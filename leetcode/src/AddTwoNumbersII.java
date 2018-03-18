/** https://leetcode.com/problems/add-two-numbers-ii/description/ */
class AddTwoNumbersII {
  ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    l1 = reverse(l1);
    l2 = reverse(l2);
    return reverse(add(l1, l2));
  }

  ListNode add(ListNode l1, ListNode l2) {
    ListNode fakeHead = new ListNode(0);
    ListNode curr = fakeHead;
    int carry = 0;
    int digit = 0;
    while (l1 != null || l2 != null) {
      int x = l1 == null ? 0 : l1.val;
      int y = l2 == null ? 0 : l2.val;
      int sum = x + y + carry;
      digit = sum % 10;
      carry = sum / 10;
      curr.next = new ListNode(digit);
      curr = curr.next;
      l1 = l1 == null ? null : l1.next;
      l2 = l2 == null ? null : l2.next;
    }
    if (carry > 0) {
      curr.next = new ListNode(carry);
    }
    return fakeHead.next;
  }

  ListNode reverse(ListNode head) {
    if (head == null) {
      return null;
    }
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

  class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
      val = x;
    }
  }
}
