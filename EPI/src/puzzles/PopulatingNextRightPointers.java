package puzzles;

/**
 * Created by Pankaj on 1/1/16.
 */
public class PopulatingNextRightPointers {
    /**
     * Updates the next field for every node in a perfect binary tree
     * Time : O(n)
     * Space : O(1)
     *
     * @param root the root of the given tree
     */
    public static void populateNextPointer(BinaryTreeNode<Integer> root) {
        while (root != null) {
            BinaryTreeNode<Integer> parent = root;
            while (parent != null && parent.left != null) {
                parent.left.next = parent.right;
                if (parent.next != null) parent.right.next = parent.next.left;
                parent = parent.next;
            }
            root = root.left;
        }
    }

    /**
     * Updates the next field for every node in a perfect binary tree
     * Time : O(n)
     * Space : O(logn)
     *
     * @param root the root of the given tree
     */
    public static void populateNextPointer1(BinaryTreeNode<Integer> root) {
        if (root == null) return;
        populateNextPointer1(root.left);
        populateNextPointer1(root.right);
        BinaryTreeNode<Integer> left = root.left;
        BinaryTreeNode<Integer> right = root.right;
        while (left != null && right != null) {
            left.next = right;
            left = left.right;
            right = right.left;
        }
    }

    public static class BinaryTreeNode<T> {
        public T data;
        public BinaryTreeNode<T> left;
        public BinaryTreeNode<T> right;
        public BinaryTreeNode<T> next;

        public BinaryTreeNode(T data) {
            this.data = data;
        }
    }
}
