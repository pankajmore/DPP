package utils;

/**
 * Created by Pankaj on 6/12/15.
 */
public class BinaryTreeNode {
    private int val;
    private BinaryTreeNode left;
    private BinaryTreeNode right;

    public BinaryTreeNode(int val, BinaryTreeNode left, BinaryTreeNode right)
    {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public BinaryTreeNode getLeft() {
        return left;
    }

    public BinaryTreeNode getRight() {
        return right;
    }
}

