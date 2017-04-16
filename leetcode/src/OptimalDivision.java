/** https://leetcode.com/problems/optimal-division/ Created by pankaj on 16/04/17. */
public class OptimalDivision {
  public String optimalDivision(int[] nums) {
    int N = nums.length;
    if (N == 0) return "";
    float[][] max = new float[N][N];
    float[][] min = new float[N][N];
    int[][] maxIdx = new int[N][N];
    int[][] minIdx = new int[N][N];
    for (int i = N - 1; i >= 0; i--) {
      max[i][i] = min[i][i] = (float) nums[i];
      for (int j = i + 1; j < N; j++) {
        for (int k = i; k < j; k++) {
          float curr = max[i][k] / min[k + 1][j];
          if (max[i][j] == 0) max[i][j] = curr;
          else max[i][j] = Math.max(max[i][j], curr);
          if (max[i][j] == curr) maxIdx[i][j] = k;
          curr = min[i][k] / max[k + 1][j];
          if (min[i][j] == 0) min[i][j] = curr;
          else min[i][j] = Math.min(min[i][j], curr);
          if (min[i][j] == curr) minIdx[i][j] = k;
        }
      }
    }
    TreeNode root = build(maxIdx, minIdx, 0, N - 1, true);
    return format(nums, root);
  }

  private String format(int[] nums, TreeNode root) {
    if (root == null) return "";
    if (root.left == null && root.right == null) return String.valueOf(nums[root.val]);
    String left = format(nums, root.left);
    String right = format(nums, root.right);
    if (left == null && right == null) return null;
    else if (left == null) return right;
    else if (right == null) return left;
    else if (!right.contains("/")) return left + "/" + right;
    else return left + "/" + "(" + right + ")";
  }

  private TreeNode build(int[][] maxIdx, int[][] minIdx, int i, int j, boolean maximize) {
    if (i > j) return null;
    if (i == j) return new TreeNode(i);
    int k = maximize ? maxIdx[i][j] : minIdx[i][j];
    TreeNode root = new TreeNode(k);
    root.left = build(maxIdx, minIdx, i, k, maximize);
    root.right = build(maxIdx, minIdx, k + 1, j, !maximize);
    return root;
  }

  private static class TreeNode {
    TreeNode left, right;
    int val;

    TreeNode(int val) {
      this.val = val;
    }
  }
}
