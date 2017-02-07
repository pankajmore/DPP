import java.util.*;

/**
 * https://leetcode.com/problems/most-frequent-subtree-sum/
 * Created by pankaj on 07/02/17.
 */
public class MostFrequentSubtreeSum {
    public int[] findFrequentTreeSum(TreeNode root) {
        Map<Integer, Integer> map = new HashMap<>();
        buildTreeSum(root, map);
        if (map.isEmpty()) return new int[]{};
        int max = Collections.max(map.values());
        List<Integer> l = new ArrayList<>();
        for (int sum : map.keySet()) {
            if (map.get(sum) == max) l.add(sum);
        }
        int[] res = new int[l.size()];
        for (int i = 0; i < res.length; i++) res[i] = l.get(i);
        return res;
    }

    private int buildTreeSum(TreeNode root, Map<Integer, Integer> map) {
        if (root == null) {
            return 0;
        } else {
            int leftSum = buildTreeSum(root.left, map);
            int rightSum = buildTreeSum(root.right, map);
            int sum = root.val + leftSum + rightSum;
            map.put(sum, map.getOrDefault(sum, 0) + 1);
            return sum;
        }
    }

    private class TreeNode {
        int val;
        TreeNode left, right;
    }
}
