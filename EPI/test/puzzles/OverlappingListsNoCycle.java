package puzzles;

import utils.Node;

/**
 * Created by Pankaj on 10/2/15.
 */
public class OverlappingListsNoCycle {
    public static Node overlappingListsNoCycle(Node l1, Node l2) {
        Node x = l1, y = l2;
        if (x == null || y == null) return null;
        int len1 = x.length();
        int len2 = y.length();
        if (len1 > len2) x = x.kthNext(len1 - len2);
        else y = y.kthNext(len2 - len1);
        while (x != null && y != null && x != y) {
            x = x.next;
            y = y.next;
        }
        return x;
    }
}
