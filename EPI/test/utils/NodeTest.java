package utils;

import org.junit.Test;

import java.util.Arrays;

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

    @Test
    public void testIsPalindrome() throws Exception {
        assert new Node(new int[]{1, 2, 1}).isPalindrome();
        assert new Node(new int[]{1, 1}).isPalindrome();
        assert new Node(new int[]{1, 2, 2, 1}).isPalindrome();
        assert !(new Node(new int[]{1, 2, 3, 1}).isPalindrome());
    }

    @Test
    public void testReverse() throws Exception {
        assert new Node(new int[]{1, 2, 3}).reverse(0, 2).toList().equals(Arrays.asList(3, 2, 1));
        assert new Node(new int[]{1, 2, 3}).reverse(0, 1).toList().equals(Arrays.asList(2, 1, 3));
        assert new Node(new int[]{1, 2, 3}).reverse(1, 2).toList().equals(Arrays.asList(1, 3, 2));
    }

    @Test
    public void testReverseKSubList() throws Exception {
        assert new Node(new int[]{1, 2, 3}).reverse(3).toList().equals(Arrays.asList(3, 2, 1));
        assert new Node(new int[]{1}).reverse(3).toList().equals(Arrays.asList(1));
        assert new Node(new int[]{1, 2}).reverse(3).toList().equals(Arrays.asList(1, 2));
        assert new Node(new int[]{1, 2, 3, 4, 5, 6, 7, 8}).reverse(3).toList().equals(Arrays.asList(3, 2, 1, 6, 5, 4, 7, 8));
        assert new Node(new int[]{1, 2, 3, 4, 5, 6}).reverse(3).toList().equals(Arrays.asList(3, 2, 1, 6, 5, 4));
        assert new Node(new int[]{1, 2, 3, 4, 5}).reverse(2).toList().equals(Arrays.asList(2, 1, 4, 3, 5));
    }
}