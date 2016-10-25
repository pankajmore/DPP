/**
 * https://leetcode.com/problems/path-sum-iii/
 * Created by pankaj on 10/24/16.
 */
public class PathSumIII {
    public int pathSum(TreeNode root, int sum) {
        if (root == null) return 0;
        return fromRootSum(root, sum) + pathSum(root.left, sum) + pathSum(root.right, sum);
    }

    public int fromRootSum(TreeNode root, int sum) {
        if (root == null) return 0;
        return (root.val == sum ? 1 : 0) + fromRootSum(root.left, sum - root.val) + fromRootSum(root.right, sum - root.val);
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
