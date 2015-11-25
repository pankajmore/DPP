package utils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Pankaj on 6/10/15.
 */
public class Node {
    public int val;
    public Node next;

    public Node() {
    }

    public Node(int[] A) throws Exception {
        if (A.length == 0)
            throw (new Exception("Cannot create an empty linked list!"));
        this.val = A[0];
        Node curr = this;
        for (int i = 1; i < A.length; i++) {
            curr.next = new Node();
            curr.next.val = A[i];
            curr = curr.next;
        }
    }

    public static Node prepend(Node h, int x) {
        Node n = new Node();
        n.val = x;
        n.next = h;
        return n;
    }

    public List<Integer> toList() {
        Node curr = this;
        List<Integer> l = new ArrayList<>();
        while (curr != null) {
            l.add(curr.val);
            curr = curr.next;
        }
        return l;
    }

    public int length() {
        Node head = this;
        int len = 0;
        while (head != null) {
            head = head.next;
            len++;
        }
        return len;
    }

    public Node kthNext(int k) {
        Node curr = this;
        while (k-- > 0) {
            curr = curr.next;
            if (curr == null) return null;
        }
        return curr;
    }

    public Node kthLast(int k) throws Exception {
        Node x = this, y = this;
        while (k-- > 0) {
            if (y == null) throw new Exception("Index k out of bounds");
            y = y.next;
        }
        while (y != null) {
            x = x.next;
            y = y.next;
        }
        return x;
    }

    public Node removeKthLast(int k) throws Exception {
        Node n;
        try {
            n = this.kthLast(k + 1);
            Node toBeDeleted = n.next;
            n.next = toBeDeleted.next;
            return this;
        } catch (Exception e) {
            n = this.kthLast(k);
            assert (n == this);
            Node newHead = this.next;
            this.next = null;
            return newHead;
        }
    }

    public Node iReverse() {
        Node temp, curr = this, rest = null;
        while (curr != null) {
            temp = curr.next;
            curr.next = rest;
            rest = curr;
            curr = temp;
        }
        return rest;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(val);
        Node curr = next;
        Node startOfCycle = checkCycle();
        if (startOfCycle != null) {
            for (int i = 0; i < 2; i++) {
                while (curr != startOfCycle) {
                    sb.append(" -> ");
                    sb.append(curr.val);
                    curr = curr.next;
                }
                sb.append(" || ");
                sb.append(curr.val);
                curr = curr.next;
            }
            return sb.toString();
        }
        while (curr != null) {
            sb.append(" -> ");
            sb.append(curr.val);
            curr = curr.next;
        }
        return sb.toString();
    }

    public Node introduceCycle(int i) throws Exception {
        Node to = this, from = this;
        if (checkCycle() != null) throw new Exception("already a cycle");
        while (from.next != null) from = from.next;
        while (--i > 0) {
            to = to.next;
            if (to == null) throw (new Exception("index is too large for the list"));
        }
        from.next = to;
        return this;
    }

    public Node checkCycle() {
        Node slow = this, fast = this;
        while (true) {
            slow = slow.next;
            fast = fast.next;
            if (slow == null || fast == null || fast.next == null) return null;
            fast = fast.next;
            if (slow.equals(fast)) {
                slow = this;
                while (!fast.equals(slow)) {
                    slow = slow.next;
                    fast = fast.next;
                }
                return slow;
            }
        }
    }
}
