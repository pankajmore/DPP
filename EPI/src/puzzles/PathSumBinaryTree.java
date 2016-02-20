package puzzles;

import utils.BinaryTreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by pankaj on 2/20/16.
 */
public class PathSumBinaryTree {
    public static boolean leafWithPathSum(BinaryTreeNode root, int sum) {
        if (root == null) return false;
        if (root.left == null && root.right == null) return sum == root.val();
        return leafWithPathSum(root.left, sum - root.val()) || leafWithPathSum(root.right, sum - root.val());
    }

    public static List<BinaryTreeNode> pathWithSum(BinaryTreeNode root, int sum) {
        List<BinaryTreeNode> path = new ArrayList<>();
        pathWithSumHelper(root, sum, path);
        return path;
    }

    private static boolean pathWithSumHelper(BinaryTreeNode root, int sum, List<BinaryTreeNode> path) {
        if (root == null) return false;
        path.add(root);
        sum -= root.val();
        if ((root.left == null && root.right == null && sum == 0)
                || pathWithSumHelper(root.left, sum, path)
                || pathWithSumHelper(root.right, sum, path))
            return true;
        path.remove(path.size() - 1);
        return false;
    }

    public static List<List<BinaryTreeNode>> allPathsWithSum(BinaryTreeNode root, int sum) {
        List<List<BinaryTreeNode>> allPaths = new ArrayList<>();
        List<BinaryTreeNode> path = new ArrayList<>();
        allPathsWithSumHelper(root, sum, path, allPaths);
        return allPaths;
    }

    private static void allPathsWithSumHelper(BinaryTreeNode root, int sum, List<BinaryTreeNode> path, List<List<BinaryTreeNode>> allPaths) {
        if (root == null) return;
        path.add(root);
        sum -= root.val();
        if (root.left == null && root.right == null && sum == 0) allPaths.add(new ArrayList<>(path));
        allPathsWithSumHelper(root.left, sum, path, allPaths);
        allPathsWithSumHelper(root.right, sum, path, allPaths);
        path.remove(path.size() - 1);
    }
}
