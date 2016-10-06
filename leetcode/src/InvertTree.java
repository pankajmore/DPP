/**
 * https://leetcode.com/problems/invert-binary-tree/
 * Created by pankaj on 10/6/16.
 */
public class InvertTree {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;
        TreeNode tmp = invertTree(root.right);
        root.right = invertTree(root.left);
        root.left = tmp;
        return root;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
