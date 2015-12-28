package puzzles;

import utils.Node;

/**
 * Created by Pankaj on 12/28/15.
 */
public class ZippingList {
    public static Node zip(Node l) {
        if (l == null || l.next == null) return l;
        return merge(l, reverse(breakAtMid(l)));
    }

    private static Node merge(Node a, Node b) {
        Node head = a, nextA, nextB, prevA = null;
        while (a != null && b != null) {
            nextA = a.next;
            nextB = b.next;
            a.next = b;
            b.next = nextA;
            prevA = a;
            a = nextA;
            b = nextB;
        }
        if (a != null) {
            a = prevA; //shift a to the last node in a
            while (a != null && a.next != null) a = a.next;
            assert a != null;
            a.next = b;
        } else if (b != null) {
            assert prevA != null;
            prevA.next = b;
        }
        return head;
    }

    private static Node reverse(Node l) {
        if (l == null || l.next == null) return l;
        Node prev = l, curr = l.next, next;
        prev.next = null;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    private static Node breakAtMid(Node l) {
        int size = l.length();
        int prevMid = (size - 1) / 2;
        while (prevMid-- > 0) l = l.next;
        Node mid = l.next;
        l.next = null;
        return mid;
    }
}
