package puzzles;

/**
 * Created by Pankaj on 1/1/16.
 */
public class PopulatingNextRightPointers {
    public static void populateNextPointer(BinaryTreeNode<Integer> root) {
        if (root == null) return;
        populateNextPointer(root.left);
        populateNextPointer(root.right);
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
