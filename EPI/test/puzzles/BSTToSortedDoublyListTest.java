package puzzles;

import examples.BinaryTreeExample;
import org.junit.Test;
import puzzles.BSTToSortedDoublyList.Pointer;
import utils.BinaryTreeNode;

import static puzzles.BSTToSortedDoublyList.convertBSTToDoublyList;

public class BSTToSortedDoublyListTest {

    @Test
    public void testConvertBSTToDoublyList() throws Exception {
        Pointer p = convertBSTToDoublyList(new Pointer(BinaryTreeExample.constructBSTExample()));
        BinaryTreeNode head = p.root;
        while (head.right != null) {
            assert head.val() < head.right.val();
            head = head.right;
        }
        while (head.left != null) {
            assert head.val() > head.left.val();
            head = head.left;
        }
    }
}