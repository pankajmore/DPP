package puzzles;

import com.sun.istack.internal.NotNull;
import utils.Node;

/**
 * Created by Pankaj on 12/28/15.
 */
public class ZippingList {
    /**
     * Time: O(N)
     * Space: O(1)
     *
     * @param l linked list of size N
     * @return zipped version of l
     */
    @NotNull public static Node zip(@NotNull Node l) {
        if (l == null || l.next == null) return l;
        return merge(l, reverse(breakAtMid(l)));
    }

    /**
     * Time: O(N)
     * Space: O(N)
     *
     * @param A an array of size N
     * @return zipped version of A
     */
    @NotNull public static int[] zip1(@NotNull int[] A) {
        int[] B = new int[A.length];
        int idx = 0, i = 0, j = A.length - 1;
        while (i < j) {
            B[idx++] = A[i];
            B[idx++] = A[j];
            i++;
            j--;
        }
        if (i == j) B[idx] = A[i];
        return B;
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
