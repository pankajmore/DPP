package puzzles;

import utils.BinaryTreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by pankaj on 3/20/16.
 */
public class UniqueBinaryTreesAll {
    /**
     * Time : O(Catalan Number)
     * Space: O(Catalan Number)
     *
     * @param N number of nodes in the binary tree
     * @return the list of all distinct binary trees of size N
     */
    public static List<BinaryTreeNode> generateAllBinaryTrees(int N) {
        List<BinaryTreeNode> trees = new ArrayList<>();
        if (N == 0) {
            trees.add(null);
            return trees;
        }
        for (int i = 0; i < N; i++) {
            List<BinaryTreeNode> leftSubtrees = generateAllBinaryTrees(i);
            List<BinaryTreeNode> rightSubtrees = generateAllBinaryTrees(N - i - 1);
            for (BinaryTreeNode left : leftSubtrees) {
                for (BinaryTreeNode right : rightSubtrees) {
                    trees.add(new BinaryTreeNode(0, left, right));
                }
            }
        }
        return trees;
    }
}
