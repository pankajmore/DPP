package utils;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Created by pankaj on 7/6/16.
 */
public class RandomListNode {
    int label;
    RandomListNode next, random;
    int order = -1;

    public RandomListNode(int label) {
        this.label = label;
    }

    public static void jumpFirstOrderRecursive(RandomListNode n) {
        jumpFirstOrderHelper(n, new int[]{0});
    }

    private static void jumpFirstOrderHelper(RandomListNode n, int[] order) {
        if (n == null) return;
        if (n.order == -1) {
            n.order = order[0]++;
            jumpFirstOrderHelper(n.random, order);
            jumpFirstOrderHelper(n.next, order);
        }
    }

    public static void jumpFirstOrderIterative(RandomListNode n) {
        int order = 0;
        Deque<RandomListNode> stack = new LinkedList<>();
        stack.push(n);
        while (!stack.isEmpty()) {
            RandomListNode curr = stack.pop();
            if (curr.order == -1) {
                curr.order = order++;
                if (curr.next != null) stack.push(curr.next);
                if (curr.random != null) stack.push(curr.random);
            }
        }
    }

    /**
     * Time : O(N)
     * Space : O(N)
     * <p>
     * Extra space required is O(1)
     * Original list is mutated and restored at the end
     *
     * @return a deep-copy of the original list
     */
    public RandomListNode copyRandomList() {
        RandomListNode curr = this;
        while (curr != null) {
            RandomListNode newNode = new RandomListNode(curr.label);
            newNode.next = curr.next;
            curr.next = newNode;
            curr = newNode.next;
        }
        curr = this;
        while (curr != null) {
            if (curr.random != null)
                curr.next.random = curr.random.next;
            curr = curr.next.next;
        }
        curr = this;
        RandomListNode newHead = curr.next, newCurr = curr.next;
        while (curr != null) {
            curr.next = newCurr.next;
            curr = curr.next;
            if (curr != null) newCurr.next = curr.next;
            newCurr = newCurr.next;
        }
        return newHead;
    }

}
