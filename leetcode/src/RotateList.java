/**
 * https://leetcode.com/problems/rotate-list/
 * Created by pankaj on 8/18/16.
 */
public class RotateList {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || k == 0) return head;
        int N = 1;
        ListNode tail = head;
        while (tail.next != null) {
            tail = tail.next;
            N++;
        }
        if ((k %= N) != 0) {
            tail.next = head;
            for (int i = 0; i < N - k; i++) tail = tail.next;
            head = tail.next;
            tail.next = null;
        }
        return head;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}