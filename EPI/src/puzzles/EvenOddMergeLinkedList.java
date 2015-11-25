package puzzles;

import utils.Node;

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
}
