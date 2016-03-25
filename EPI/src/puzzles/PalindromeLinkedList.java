package puzzles;

import org.jetbrains.annotations.NotNull;
import utils.Node;

/**
 * Created by pankaj on 3/24/16.
 */
public class PalindromeLinkedList {
    /**
     * Time : O(N)
     * Space: O(N)
     *
     * @param head singly linked list of size N
     * @return true if list is a palindrome
     */
    public static boolean isPalindrome(Node head) {
        return head.toList().equals(head.reverse().toList());
    }

    /**
     * Time : O(N)
     * Space: O(1)
     * <p>
     * Mutates the list intermittently
     *
     * @param head singly linked list of size N
     * @return true if list is a palindrome
     */
    public static boolean isPalindrome1(@NotNull Node head) {
        if (head.next == null) return true;
        Node x = head, mid = reverse(breakAtMid(head)), y = mid;
        boolean res = true;
        while (x != null && y != null) {
            if (x.val != y.val) {
                res = false;
                break;
            }
            x = x.next;
            y = y.next;
        }
        mid = reverse(mid);
        Node curr = head;
        while (curr.next != null) curr = curr.next;
        curr.next = mid;
        return res;
    }

    private static Node reverse(Node head) {
        Node prev = null, curr = head;
        while (curr != null) {
            Node next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    private static Node breakAtMid(Node head) {
        Node slow = head, fast = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        Node res = slow.next;
        slow.next = null;
        return res;
    }

}
