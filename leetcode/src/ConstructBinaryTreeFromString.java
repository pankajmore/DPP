/**
 * https://leetcode.com/problems/construct-binary-tree-from-string/ Created by pankaj on 12/03/17.
 */
public class ConstructBinaryTreeFromString {
  public TreeNode str2tree(String s) {
    return str2treeHelper(s, 0, s.length() - 1);
  }

  private TreeNode str2treeHelper(String s, int begin, int end) {
    if (begin > end) return null;
    int i = begin;
    boolean neg = s.charAt(i) == '-';
    if (neg) i++;
    int val = 0;
    char c = s.charAt(i);
    while (i <= end && (c = s.charAt(i)) != '(') {
      val = val * 10 + (c - '0');
      i++;
    }
    if (neg) val = -val;
    TreeNode root = new TreeNode(val);
    if (i <= end && c == '(') {
      int cnt = 1, leftBegin = i + 1;
      while (cnt > 0) {
        c = s.charAt(++i);
        if (c == '(') cnt++;
        else if (c == ')') cnt--;
      }
      root.left = str2treeHelper(s, leftBegin, i - 1);
    }
    ++i;
    if (i <= end) {
      root.right = str2treeHelper(s, i + 1, end - 1);
    }
    return root;
  }

  private static class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode(int val) {
      this.val = val;
    }
  }
}
