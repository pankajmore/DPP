package puzzles;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by pankaj on 1/15/16.
 */
public class TreeDiameter {
    /**
     * Time : O(n)
     * Space : O(h) where h is the maximum height of the tree
     *
     * @param root a tree rooted at root with n nodes
     * @return the maximum diameter of the tree
     */
    public static double computeDiameter(TreeNode root) {
        return root == null ? 0 : computeHeightAndDiameter(root).diameter;
    }

    public static HeightAndDiameter computeHeightAndDiameter(TreeNode n) {
        double[] heights = new double[2]; //max 2 heights
        if (n.edges.isEmpty()) return new HeightAndDiameter(0.0, 0.0);
        double bestDiameter = 0.0;
        for (Edge e : n.edges) {
            HeightAndDiameter heightAndDiameter = computeHeightAndDiameter(e.root);
            Double height = heightAndDiameter.height + e.length, diameter = heightAndDiameter.diameter;
            if (height > heights[0]) {
                heights[1] = heights[0];
                heights[0] = height;
            } else if (height > heights[1]) {
                heights[1] = height;
            }
            if (diameter > bestDiameter) bestDiameter = diameter;
        }
        if (heights[0] + heights[1] > bestDiameter) bestDiameter = heights[0] + heights[1];
        return new HeightAndDiameter(heights[0], bestDiameter);
    }

    public static class TreeNode {
        List<Edge> edges = new ArrayList<>();
    }

    public static class Edge {
        public TreeNode root;
        public Double length;

        public Edge(TreeNode root, Double length) {
            this.root = root;
            this.length = length;
        }
    }

    public static class HeightAndDiameter {
        public Double height;
        public Double diameter;

        public HeightAndDiameter(Double height, Double diameter) {
            this.height = height;
            this.diameter = diameter;
        }
    }
}
