package puzzles;

import utils.Node;

/**
 * Created by pankaj on 5/27/16.
 */
public class AddTwoNumberList {
    public static Node add(Node x, Node y) {
        Node r = new Node(), head = r;
        int carry = 0;
        while (x != null || y != null) {
            int xVal = x == null ? 0 : x.val;
            int yVal = y == null ? 0 : y.val;
            int d = (xVal + yVal + carry) % 10;
            carry = (xVal + yVal + carry) / 10;
            r.next = new Node(d);
            r = r.next;
            if (x != null) x = x.next;
            if (y != null) y = y.next;
        }
        if (carry != 0) r.next = new Node(carry);
        return head.next;
    }
}
