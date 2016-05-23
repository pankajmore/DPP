package puzzles;

import utils.Node;

import java.util.List;

/**
 * Created by Pankaj on 12/28/15.
 */
public class ZippingList {
    public static Node zip(Node l) {
        if (l == null || l.next == null) return l;
        return merge(l, reverse(breakAtMid(l)));
    }

    public static Node zip1(Node l) throws Exception {
        if (l == null || l.next == null) return l;
        List<Integer> A = l.toList();
        int[] B = new int[A.size()];
        int idx = 0, i = 0, j = A.size() - 1;
        while (i < j) {
            B[idx++] = A.get(i);
            B[idx++] = A.get(j);
            i++;
            j--;
        }
        if (i == j) B[idx] = A.get(i);
        return new Node(B);
    }

    private static Node merge(Node a, Node b) {
        Node dummyHead = new Node(), curr = dummyHead;
        while (b != null) {
            curr.next = a;
            curr = a;
            a = a.next;
            curr.next = b;
            curr = b;
            b = b.next;
        }
        curr.next = a;
        return dummyHead.next;
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
