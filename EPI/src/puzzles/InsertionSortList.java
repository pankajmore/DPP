package puzzles;

import utils.Node;

/**
 * Created by pankaj on 2/9/16.
 */
public class InsertionSortList {
    /**
     * Time : O(N^2)
     * Space : O(1)
     *
     * @param head the head of a list of size N
     * @return the head of the "sorted" list
     */
    public static Node insertionSortList(Node head) {
        if (head == null) return null;
        Node curr = head, newHead = head;
        while (curr.next != null) {
            if (curr.val > curr.next.val) {
                Node x = curr.next;
                curr.next = curr.next.next;
                x.next = null;
                newHead = insert(newHead, x);
            } else {
                curr = curr.next;
            }
        }
        return newHead;
    }

    private static Node insert(Node head, Node x) {
        if (x.val < head.val) {
            x.next = head;
            return x;
        }
        Node curr = head, next = head.next;
        while (next != null) {
            if (curr.val <= x.val && x.val < next.val) {
                curr.next = x;
                x.next = next;
                return head;
            }
            curr = next;
            next = curr.next;
        }
        assert false;
        return null;
    }
}
