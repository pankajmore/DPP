package puzzles;

import utils.Node;

/**
 * Created by pankaj on 3/24/16.
 */
public class PalindromeLinkedList {
    /**
     * Time : O(N)
     * Space: O(N)
     *
     * @param head linked list of size N
     * @return true if list is a palindrome
     */
    public static boolean isPalindrome(Node head) {
        return head.toList().equals(head.reverse().toList());
    }
}
