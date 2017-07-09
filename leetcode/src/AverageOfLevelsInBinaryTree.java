import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode.com/problems/average-of-levels-in-binary-tree/ Created by pankaj on 09/07/17.
 */
class AverageOfLevelsInBinaryTree {
  List<Double> averageOfLevels(final TreeNode root) {
    List<Double> averages = new ArrayList<>();
    if (root == null) {
      return averages;
    }
    Deque<TreeNode> q = new LinkedList<>();
    q.add(root);
    q.add(null);
    double sum = 0;
    int cnt = 0;
    while (!q.isEmpty()) {
      TreeNode n = q.remove();
      if (n == null) {
        averages.add(sum / cnt);
        sum = 0;
        cnt = 0;
        if (!q.isEmpty()) {
          q.add(null);
        }
      } else {
        cnt++;
        sum += n.val;
        if (n.left != null) {
          q.add(n.left);
        }
        if (n.right != null) {
          q.add(n.right);
        }
      }
    }
    return averages;
  }

  class TreeNode {
    private int val;
    private TreeNode left;
    private TreeNode right;
  }
}
