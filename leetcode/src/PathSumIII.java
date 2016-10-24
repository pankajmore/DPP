/**
 * https://leetcode.com/problems/path-sum-iii/
 * Created by pankaj on 10/24/16.
 */
public class PathSumIII {
    public int pathSum(TreeNode root, int sum) {
        if (root == null) return 0;
        return pathSum1(root, sum) + pathSum(root.left, sum) + pathSum(root.right, sum);
    }

    public int pathSum1(TreeNode root, int sum) {
        if (root == null) return 0;
        return (root.val == sum ? 1 : 0) + pathSum1(root.left, sum - root.val) + pathSum1(root.right, sum - root.val);
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
