/**
 * https://leetcode.com/problems/symmetric-tree/
 * Created by pankaj on 25/12/16.
 */
public class SymmetricTree {
    public boolean isSymmetric(TreeNode root) {
        return isSymmetricHelper(root.left, root.right);
    }

    private boolean isSymmetricHelper(TreeNode left, TreeNode right) {
        if (left == null || right == null) return left == right;
        return left.val == right.val && isSymmetricHelper(left.left, right.right) && isSymmetricHelper(left.right, right.left);
    }

    public class TreeNode {
        int val;
        TreeNode left, right;
    }
}
