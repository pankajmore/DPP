package puzzles;

import utils.BinaryTreeNode;

/**
 * Created by pankaj on 2/18/16.
 */
public class SumRootToLeafBinaryTree {
    /**
     * Time : O(N)
     * Space : O(H)
     *
     * @param root binary tree of size N , each root-to-leaf path encodes a binary integer
     * @return the sum of all root-to-leaf encoded integers
     */
    public int sumRumToLeaf(BinaryTreeNode root) {
        if (root == null) return 0;
        return sumRumToLeafHelper(root, 0);
    }

    private int sumRumToLeafHelper(BinaryTreeNode root, int num) {
        if (root == null) return 0;
        num = num << 1 + root.val();
        if (root.left == null && root.right == null) return num;
        return sumRumToLeafHelper(root.left, num) + sumRumToLeafHelper(root.right, num);
    }
}
