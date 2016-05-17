package puzzles;

import utils.Node;

import java.util.List;

/**
 * Created by Pankaj on 11/25/15.
 */
public class EvenOddMergeLinkedList {
    public static Node evenOddMerge(Node l) {
        if (l == null) return null;

        Node oddHead = l.next;
        Node evenIter = l, oddIter = oddHead;

        while (oddIter != null) {
            evenIter.next = oddIter.next;
            if (evenIter.next == null) {
                evenIter.next = oddHead;
                return l;
            } else {
                evenIter = evenIter.next;
                oddIter.next = evenIter.next;
                oddIter = oddIter.next;
            }
        }
        if (evenIter.next == null) evenIter.next = oddHead;
        return l;
    }

    public static Node evenOddMerge1(Node l) throws Exception {
        List<Integer> A = l.toList();
        int[] B = new int[A.size()];
        for (int i = 0; i < A.size(); i++) {
            if (i % 2 == 0) B[i / 2] = A.get(i);
            else B[(A.size() + i) / 2] = A.get(i);
        }
        return new Node(B);
    }
}
