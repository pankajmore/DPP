package puzzles;

import org.junit.Test;
import utils.Node;

import static puzzles.PalindromeLinkedList.isPalindrome;
import static puzzles.PalindromeLinkedList.isPalindrome1;

/**
 * Created by pankaj on 3/24/16.
 */
public class PalindromeLinkedListTest {

    @Test
    public void testIsPalindrome() throws Exception {
        assert isPalindrome(new Node(new int[]{1}));
        assert isPalindrome(new Node(new int[]{1, 1}));
        assert isPalindrome(new Node(new int[]{1, 2, 1}));
        assert !isPalindrome(new Node(new int[]{1, 2, 3}));
        assert isPalindrome(new Node(new int[]{1, 3, 3, 1}));
        assert isPalindrome(new Node(new int[]{1, 4, 6, 4, 1}));
    }

    @Test
    public void testIsPalindrome1() throws Exception {
        assert isPalindrome1(new Node(new int[]{1}));
        assert isPalindrome1(new Node(new int[]{1, 1}));
        assert isPalindrome1(new Node(new int[]{1, 2, 1}));
        assert !isPalindrome1(new Node(new int[]{1, 2, 3}));
        assert isPalindrome1(new Node(new int[]{1, 3, 3, 1}));
        assert isPalindrome1(new Node(new int[]{1, 4, 6, 4, 1}));
    }
}