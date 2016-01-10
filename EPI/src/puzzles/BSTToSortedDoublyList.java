package puzzles;


import utils.BinaryTreeNode;

/**
 * Created by Pankaj on 1/10/16.
 */
public class BSTToSortedDoublyList {
    /**
     * Time : O(n)
     * Space : O(h)
     *
     * @param p takes a pointer to a BST and converts it to a sorted doubly linked list
     * @return the pointer to head of the list
     */
    public static Pointer convertBSTToDoublyList(Pointer p) {
        Pair pair = convertBSTToDoublyList(p.root);
        return new Pointer(pair.front);
    }

    private static Pair convertBSTToDoublyList(BinaryTreeNode root) {
        if (root == null) return new Pair(null, null);
        BinaryTreeNode front = root, back = root;
        Pair left = convertBSTToDoublyList(root.left);
        Pair right = convertBSTToDoublyList(root.right);
        if (left.back != null) {
            front = left.front;
            left.back.right = root;
            root.left = left.back;
        }
        if (right.front != null) {
            back = right.back;
            right.front.left = root;
            root.right = right.front;
        }
        return new Pair(front, back);
    }

    public static class Pair {
        final BinaryTreeNode front;
        final BinaryTreeNode back;

        public Pair(BinaryTreeNode front, BinaryTreeNode back) {
            this.front = front;
            this.back = back;
        }
    }

    public static class Pointer {
        public final BinaryTreeNode root;

        public Pointer(BinaryTreeNode root) {
            this.root = root;
        }
    }
}
