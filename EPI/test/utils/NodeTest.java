package utils;

import org.junit.Test;

public class NodeTest {

    @Test
    public void testKthLast() throws Exception {
        Node n = new Node(new int[]{1});
        assert n.kthLast(1) == n;
        n = new Node(new int[]{1, 2, 3});
        assert n.kthLast(1).val == 3;
        assert n.kthLast(2).val == 2;
        assert n.kthLast(3).val == 1;
        //n.kthLast(4);
    }

    @Test
    public void testRemoveKthLast() throws Exception {
        Node n;
        n = new Node(new int[]{1});
        assert n.removeKthLast(1) == null;
        n = new Node(new int[]{1, 2, 3});
        n = n.removeKthLast(3);
        assert n.val == 2;
        assert n.removeKthLast(1).val == 2;
        assert n.removeKthLast(1) == null;
    }
}