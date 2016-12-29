import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode.com/problems/binary-tree-level-order-traversal-ii/
 * Created by pankaj on 29/12/16.
 */
public class BinaryTreeLevelOrderTraversalII {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        LinkedList<List<Integer>> levels = new LinkedList<>();
        if (root == null) return levels;
        Deque<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            List<Integer> level = new ArrayList<>();
            int size = q.size();
            while (size-- > 0) {
                TreeNode n = q.remove();
                level.add(n.val);
                if (n.left != null) q.add(n.left);
                if (n.right != null) q.add(n.right);
            }
            levels.addFirst(level);
        }
        return levels;
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
