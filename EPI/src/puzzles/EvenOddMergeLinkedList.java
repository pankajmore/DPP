package puzzles;

import com.sun.istack.internal.NotNull;
import utils.Node;

import java.util.List;

/**
 * Created by Pankaj on 11/25/15.
 */
public class EvenOddMergeLinkedList {
    public static Node evenOddMerge(Node l) {
        if (l == null) return null;

        Node oddHead = l.next;
        Node even = l, odd = oddHead;

        while (odd != null) {
            even.next = odd.next;
            if (even.next == null) {
                even.next = oddHead;
                return l;
            } else {
                even = even.next;
                odd.next = even.next;
                odd = odd.next;
            }
        }
        if (even.next == null) even.next = oddHead;
        return l;
    }

    public static Node evenOddMerge1(@NotNull Node l) throws Exception {
        List<Integer> A = l.toList();
        int[] B = new int[A.size()];
        for (int i = 0; i < A.size(); i++) {
            if (i % 2 == 0) B[i / 2] = A.get(i);
            else B[(A.size() + i) / 2] = A.get(i);
        }
        return new Node(B);
    }
}
