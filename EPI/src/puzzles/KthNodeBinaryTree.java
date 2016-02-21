package puzzles;

import java.util.Arrays;
import java.util.List;

/**
 * Created by pankaj on 2/21/16.
 */
public class KthNodeBinaryTree {
    /**
     * Time : O(N)
     * Space : O(H)
     *
     * @param root binary tree with size N and height H
     * @param k    integer in [1,N]
     * @return the kth node
     */
    public static utils.BinaryTreeNode kthNodeBinaryTree(utils.BinaryTreeNode root, int k) {
        return kthNodeBinaryTree(root, Arrays.asList(k));
    }

    private static utils.BinaryTreeNode kthNodeBinaryTree(utils.BinaryTreeNode root, List<Integer> k) {
        if (root == null) return null;
        utils.BinaryTreeNode left = kthNodeBinaryTree(root.left, k);
        if (left != null) return left;
        k.set(0, k.get(0) - 1);
        if (k.get(0) == 0) return root;
        return kthNodeBinaryTree(root.right, k);
    }

    /**
     * Time : O(H)
     * Space :O(1)
     *
     * @param root tree with size field. Size N and height H
     * @param k    integer in [1,N]
     * @return kth node of tree
     */
    public static BinaryTreeNode<Integer> findKthNodeBinaryTree(BinaryTreeNode<Integer> root, int k) {
        BinaryTreeNode<Integer> iter = root;
        while (iter != null) {
            int leftSize = iter.left != null ? iter.left.size : 0;
            if (leftSize + 1 < k) {
                k -= leftSize + 1;
                iter = iter.right;
            } else if (leftSize + 1 == k) return iter;
            else iter = iter.left;
        }
        return null;
    }

    public static class BinaryTreeNode<T> {
        public T data;
        public BinaryTreeNode<T> left, right;
        public int size;
    }
}
