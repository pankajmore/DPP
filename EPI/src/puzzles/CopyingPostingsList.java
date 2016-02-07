package puzzles;

/**
 * Created by pankaj on 2/7/16.
 */
public class CopyingPostingsList {
    /**
     * Time : O(N)
     * Space : O(N)
     * <p>
     * Extra space required is O(1)
     * Original list is mutated and restored at the end
     *
     * @param head the head of a RandomListNode of size N
     * @return a deep-copy of the original list
     */
    public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null) return null;
        RandomListNode curr = head;
        while (curr != null) {
            RandomListNode newNode = new RandomListNode(curr.label);
            newNode.next = curr.next;
            curr.next = newNode;
            curr = newNode.next;
        }
        curr = head;
        while (curr != null) {
            if (curr.random != null)
                curr.next.random = curr.random.next;
            curr = curr.next.next;
        }
        curr = head;
        RandomListNode newHead = curr.next, newCurr = curr.next;
        while (curr != null) {
            curr.next = newCurr.next;
            curr = curr.next;
            if (curr != null) newCurr.next = curr.next;
            newCurr = newCurr.next;
        }
        return newHead;
    }

    public static class RandomListNode {
        int label;
        RandomListNode next, random;

        public RandomListNode(int label) {
            this.label = label;
        }
    }
}
